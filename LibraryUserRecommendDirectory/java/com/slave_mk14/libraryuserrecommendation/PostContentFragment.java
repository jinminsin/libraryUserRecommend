package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PostContentFragment extends Fragment {

    TextView a,b,c,d;
    Post post_items;


    public PostContentFragment(Post a){
        post_items = a;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_postcontent,container,false);
        a= rootView.findViewById(R.id.pd_title);//title
        b= rootView.findViewById(R.id.pd_owner);//owner
        c= rootView.findViewById(R.id.pd_createDate);//createDate
        d= rootView.findViewById(R.id.pd_subtitle);//subtitle

        a.setText(post_items.getTitle());
        b.setText(post_items.getOwner());
        c.setText(post_items.getCreateDate());
        d.setText(post_items.getSubtitle());

        //yeahhh 는 yeah밑의 Fragment
        getFragmentManager().beginTransaction().replace(R.id.yeahhh,new CommentListFragment(post_items.getId())).commit();

        return rootView;
    }
}
