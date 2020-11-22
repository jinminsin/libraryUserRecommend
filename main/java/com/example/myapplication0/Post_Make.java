package com.example.myapplication0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Post_Make extends Fragment {

    TextView a,b,c,d,e;
    Post_Item post_item;

    public Post_Make(Post_Item a){
        post_item = a;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.community_post_making,container,false);
        a = rootView.findViewById(R.id.pm1);//owner
        b = rootView.findViewById(R.id.pm2);//crateDate
        c = rootView.findViewById(R.id.pm3);//password
        d = rootView.findViewById(R.id.pm4);//title
        e = rootView.findViewById(R.id.pm5); // subtitle


        a.setText(post_item.getOwner());
        b.setText(post_item.getCreateDate());
        c.setText(post_item.getPassword());
        d.setText(post_item.getTitle());
        e.setText(post_item.getSubtitle());

        //post_item의 id를 받아와서 밑에 띄워줌
        getFragmentManager().beginTransaction().replace(R.id.yeahh,new Post_Tab(post_item.getId())).commit();


        return rootView;
    }
}