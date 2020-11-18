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

public class ResultProcessing extends Fragment {
    TextView resultTextview;
    Button okBtn;
    String resultData = "";
    View.OnClickListener okBtnClick;

    ResultProcessing (String index, View.OnClickListener okBtnClick){
        this.okBtnClick = okBtnClick;
        resultData = QuestionHashmap.questionHash.get(index)[0];
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.resultpaper, container, false);

        resultTextview = view.findViewById(R.id.resultTextview);
        resultTextview.setText(resultData);
        okBtn = view.findViewById(R.id.okBtn);
        okBtn.setOnClickListener(okBtnClick);

        return view;
    }
}

