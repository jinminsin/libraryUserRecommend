package com.example.recommend;

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

public class TestResultFragment extends Fragment {
    TextView resultTextview;
    Button okBtn;
    String resultData = "";
    String resultBookCode;

    public TestResultFragment(String index){
        resultData = QuestionHashmap.questionHash.get(index)[0];
        resultBookCode = QuestionHashmap.questionHash.get(index)[1];
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.fragment_testresult, container, false);

        resultTextview = view.findViewById(R.id.resultTextview);
        resultTextview.setText(resultData);
        okBtn = view.findViewById(R.id.okBtn);
        resultTextview.setText(resultData);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                /* okBtn 핸들러 입력 */
                Log.e("okokok", "messege : ok!");
                /*
                    DB에 QuestionHashmap의 선호장르를 전달
                    기능 추가 요망
                    User->feature 가 default가 아니면, 버튼 삭제
                    okBtn.setVisible(false);
                 */
            }
        });

        return view;
    }
}