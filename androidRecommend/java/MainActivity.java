package com.example.recommend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity{
    private FragmentManager fragmentManager;
    private QuestionProcessing qnaFragment;
    private ResultProcessing resultFragment;
    private FragmentTransaction fragmentTransaction;
    View.OnClickListener tBtnClick, fBtnClick, okBtnClick;

    private String flag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        tBtnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* tbtn 핸들러 입력 */
                flag += "T";
                Log.e("input = T","flag : " + flag);
                /* QuestionHashmap의 data의 길이가 1일 경우(답에 도달함) */
                if(QuestionHashmap.questionHash.get(flag).length == 1) {
                    Log.e("move result view","flag : " + flag);
                    /* result Fragment로 이동 */
                    resultFragment = new ResultProcessing(flag, okBtnClick);
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.surveyFragment, resultFragment).commit();
                    return;
                };
                qnaFragment = new QuestionProcessing(flag,tBtnClick,fBtnClick);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.surveyFragment, qnaFragment).commit();
            }
        };
        fBtnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* fbtn 핸들러 입력 */
                flag += "F";
                Log.e("input = F","flag : " + flag);
                /* QuestionHashmap의 data의 길이가 1일 경우(답에 도달함) */
                if(QuestionHashmap.questionHash.get(flag).length == 1) {
                    Log.e("move result view","flag : " + flag);
                    /* result Fragment로 이동 */
                    resultFragment = new ResultProcessing(flag, okBtnClick);
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.surveyFragment, resultFragment).commit();
                    return;
                };
                qnaFragment = new QuestionProcessing(flag,tBtnClick,fBtnClick);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.surveyFragment, qnaFragment).commit();
            }
        };
        okBtnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view){
                /* okBtn 핸들러 입력 */
                Log.e("okokok", "messege : ok!");
                /*
                    DB에 QuestionHashmap의 선호장르를 전달
                    홈 액티비티로 이동해야함
                    기능 추가 요망
                 */
            }
        };

        qnaFragment = new QuestionProcessing(flag,tBtnClick,fBtnClick);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.surveyFragment, qnaFragment).commit();
    }
}