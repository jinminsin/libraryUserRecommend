package com.example.recommend;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionProcessing extends Fragment{
    TextView quest;
    Button tBtn,fBtn;
    String question = "";
    View.OnClickListener tBtnClick,fBtnClick;

    QuestionProcessing(String index, View.OnClickListener tBtnClick, View.OnClickListener fBtnClick){
        this.tBtnClick=tBtnClick;
        this.fBtnClick=fBtnClick;
        this.question = QuestionHashmap.questionHash.get(index)[0];
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.surveypaper, container, false);

        quest = view.findViewById(R.id.quest);
        quest.setText(question);
        tBtn = view.findViewById(R.id.tBtn);
        fBtn = view.findViewById(R.id.fBtn);
        tBtn.setOnClickListener(tBtnClick);
        fBtn.setOnClickListener(fBtnClick);

        return view;
    }


}
