package com.example.myapplication0;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Post_Detail_Tab extends Fragment {

    TextView a,b,c,d;
    Post_Item post_items;


    public Post_Detail_Tab(Post_Item a){
        post_items = a;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.community_post_detail,container,false);
        a= rootView.findViewById(R.id.ti);
        b= rootView.findViewById(R.id.ti2);
        c= rootView.findViewById(R.id.t3);
        d= rootView.findViewById(R.id.t4);

        a.setText(post_items.getTitle());
        b.setText(post_items.getOwner());
        c.setText(post_items.getCreateDate());
        d.setText(post_items.getSubtitle());

        //yeahhh 는 yeah밑의 Fragment
        getFragmentManager().beginTransaction().replace(R.id.yeahhh,new comment_Tab(post_items.getId())).commit();

        return rootView;
    }
}
