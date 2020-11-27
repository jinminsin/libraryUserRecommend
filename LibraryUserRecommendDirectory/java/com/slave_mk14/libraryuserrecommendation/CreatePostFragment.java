package com.slave_mk14.libraryuserrecommendation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CreatePostFragment extends Fragment {

    //글쓰기 textview id : createpost
    //exit button id :post_exit
    //등록 button id : post_enroll
    //View id: post_line
    //Edit Text 제목 id: cp_title
    //Edit Text 내용 id : cp_subtitle


    Post post_item;

    public CreatePostFragment(Post a){
        post_item = a;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_createpost,container,false);

        return rootView;
    }
}