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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {
    TextView quest;//질의
    Button tBtn,fBtn;//버튼
    String question = "";
    String upBtnText = "";
    String downBtnText = "";
    //질의문

    String flag = "";
    View.OnClickListener tBtnClick,fBtnClick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

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
                    MainActivity.fManager.goTestResultFragment(R.id.yeah,flag,TestFragment.this);
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
                    MainActivity.fManager.goTestResultFragment(R.id.yeah,flag,TestFragment.this);
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