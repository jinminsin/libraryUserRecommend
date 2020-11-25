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

public class TestFragment extends Fragment {
    private TextView quest;//질의
    private Button tBtn,fBtn;//버튼
    private String question = "";
    private String upBtnText = "";
    private String downBtnText = "";
    //질의문

    private String flag = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(!MainActivity.mUser.getLikeBookCode().equals("-1"))
        {
            MainActivity.fManager.goTestResultFragment(R.id.contentFragment,"C",TestFragment.this);
        }

        View view = inflater.inflate(R.layout.fragment_test, container, false);

        quest = view.findViewById(R.id.quest);
        tBtn = view.findViewById(R.id.tBtn);
        fBtn = view.findViewById(R.id.fBtn);
        tBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* tbtn 핸들러 입력 */
                flag += "T";
                Log.e("input = T","flag : " + flag);
                /* QuestionHashmap의 data의 길이가 1일 경우(답에 도달함) */
                if(QuestionHashmap.questionHash.get(flag).length == 2) {
                    Log.e("move result view","flag : " + flag);
                    /* result Fragment로 이동 */
                    MainActivity.fManager.goTestResultFragment(R.id.contentFragment,flag,TestFragment.this);
                    return;
                };
                setTextQuestionAndBtn();
            }
        });

        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* tbtn 핸들러 입력 */
                flag += "F";
                Log.e("input = F","flag : " + flag);
                /* QuestionHashmap의 data의 길이가 1일 경우(답에 도달함) */
                if(QuestionHashmap.questionHash.get(flag).length == 2) {
                    Log.e("move result view","flag : " + flag);
                    /* result Fragment로 이동 */
                    MainActivity.fManager.goTestResultFragment(R.id.contentFragment,flag,TestFragment.this);
                    return;
                };
                setTextQuestionAndBtn();
            }
        });
        setTextQuestionAndBtn();

        return view;
    }

    void setTextQuestionAndBtn(){
        question = QuestionHashmap.questionHash.get(flag)[0];
        upBtnText = QuestionHashmap.questionHash.get(flag)[1];
        downBtnText = QuestionHashmap.questionHash.get(flag)[2];
        quest.setText(question);
        tBtn.setText(upBtnText);
        fBtn.setText(downBtnText);
    }
}