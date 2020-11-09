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
    private FragmentTransaction fragmentTransaction;
    View.OnClickListener tBtnClick,fBtnClick;

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
                Log.e("ttttt","flag : " + flag);
                if(QuestionHashmap.questionHash.get(flag).length == 1) {
                    Log.e("ttttt","flag : " + flag);
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
                Log.e("ffffff","flag : " + flag);
                if(QuestionHashmap.questionHash.get(flag).length == 1) {
                    Log.e("ttttt","flag : " + flag);
                    return;
                };
                qnaFragment = new QuestionProcessing(flag,tBtnClick,fBtnClick);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.surveyFragment, qnaFragment).commit();
            }
        };

        qnaFragment = new QuestionProcessing(flag,tBtnClick,fBtnClick);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.surveyFragment, qnaFragment).commit();
        Log.e("iiiiiiiiii","flag");

    }
}