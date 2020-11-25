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

    TextView a,b,c,d,e;
    Post post_item;

    public CreatePostFragment(Post a){
        post_item = a;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_createpost,container,false);
        a = rootView.findViewById(R.id.pm_owner);//owner
        b = rootView.findViewById(R.id.pm_crateDate);//crateDate
        c = rootView.findViewById(R.id.pm_password);//password
        d = rootView.findViewById(R.id.pm_title);//title
        e = rootView.findViewById(R.id.pm_sub); // subtitle


        a.setText(post_item.getOwner());
        b.setText(post_item.getCreateDate());
        c.setText(post_item.getPassword());
        d.setText(post_item.getTitle());
        e.setText(post_item.getSubtitle());

        //post_item의 id를 받아와서 밑에 띄워줌
        getFragmentManager().beginTransaction().replace(R.id.yeahh,new PostListFragment(post_item.getId())).commit();


        return rootView;
    }
}