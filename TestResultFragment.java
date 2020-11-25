package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

public class TestResultFragment extends Fragment {
    private TextView resultTextview;
    private Button okBtn;
    private String resultData = "";
    private String resultBookCode;
    private String siblingResultBookCode;
    private RequestQueue requestQueue;
    private Response.Listener<String> responseListener;
    private boolean state = true;

    public TestResultFragment(String index){
        if(index.equals("C"))
        {
            resultData = new String("당신은 이미 조사를 마쳤어요! ");
            switch(MainActivity.mUser.getLikeBookCode()){
                case "0":
                    resultData += "당신의 취향은 비문학이군요. 맞춤법을 보면 어떤 생각을 하실까요.";
                    break;
                case "1":
                    resultData += "당신의 취향은 철학이군요. 생각이 많으신걸까요.";
                    break;
                case "2":
                    resultData += "당신의 취향은 종교로군요. 신을 믿으시나요?";
                    break;
                case "3":
                    resultData += "당신의 취향은 사회과학이군요. 사람에 대한 호기심이 많나 봐요?";
                    break;
                case "4":
                    resultData += "당신의 취향은 언어군요. 외국어 좋아하세요?";
                    break;
                case "5":
                    resultData += "당신의 취향은 자연과학이군요. 세계의 법칙과 진리!";
                    break;
                case "6":
                    resultData += "당신의 취향은 기술과학이군요. 용접 찾으러 온 건 아니죠?";
                    break;
                case "7":
                    resultData += "당신의 취향은 예술이군요. 아름다움을 추구하는 문학이죠.";
                    break;
                case "8":
                    resultData += "당신의 취향은 문학이군요. 문학은 우리의 정신을 살찌우죠.";
                    break;
                case "9":
                    resultData += "당신의 취향은 역사군요. 철과 피, 그리고 끊임없는 투쟁이었던 과거에 관심이 있으신가요?";
                    break;
            }
        }else {
            resultData = DataHashmap.questionHash.get(index)[0];
            resultBookCode = DataHashmap.questionHash.get(index)[1];
            switch(resultBookCode){
                case "0":
                    siblingResultBookCode = "8";
                    break;
                case "1":
                    siblingResultBookCode = "2";
                    break;
                case "2":
                    siblingResultBookCode = "1";
                    break;
                case "3":
                    siblingResultBookCode = "6";
                    break;
                case "4":
                    siblingResultBookCode = "9";
                    break;
                case "5":
                    siblingResultBookCode = "6";
                    break;
                case "6":
                    siblingResultBookCode = "5";
                    break;
                case "7":
                    siblingResultBookCode = "8";
                    break;
                case "8":
                    siblingResultBookCode = "0";
                    break;
                case "9":
                    siblingResultBookCode = "4";
                    break;
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.fragment_testresult, container, false);

        resultTextview = view.findViewById(R.id.resultTextview);
        resultTextview.setText(resultData);
        okBtn = view.findViewById(R.id.okBtn);
        resultTextview.setText(resultData);

        if(!MainActivity.mUser.getLikeBookCode().equals("-1")){
            okBtn.setVisibility(View.INVISIBLE);
        }

        responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               if(response.equals("1"))
               {
                   state=true;
                   MainActivity.mUser.saveLikeBookCode(resultBookCode,siblingResultBookCode);
                   MainActivity.fManager.endTestResultFragment(TestResultFragment.this);
               }
            }
        };
        requestQueue = Volley.newRequestQueue(getContext());

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* okBtn 핸들러 입력 */
                Log.e("okokok", "messege : ok!");
                if (state) {
                    state = false;
                    DBResponse.saveBookCodeResponse(requestQueue,MainActivity.mUser.getSeedid(), resultBookCode, siblingResultBookCode, responseListener);
                }
            }
        });

        return view;
    }
}