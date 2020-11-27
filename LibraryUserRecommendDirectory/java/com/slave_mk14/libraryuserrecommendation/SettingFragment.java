package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingFragment extends Fragment {
    private Button rBtn;
    /*해야할 일 1, 각 TextView에 유저의 특성 setting
     * User의 likeBookCode와 siblingCode는 스트링 "0"~"9"로 이루어져 있어 치환 필요
     * 치환값은 DataHashMap.BookCodetoBook에 있음.
     * 해야할 일 2, 초기화
     * DBResponse.resetBookCode 사용*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting,container,false);
        rBtn = rootView.findViewById(R.id.reBtn);


        return rootView;
    }
}