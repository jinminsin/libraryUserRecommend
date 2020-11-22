package com.example.myapplication0;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

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

public class comment_Tab extends Fragment {

    //댓글을 보고 쓰는곳
    ArrayList<Comment_Item> comment_items = new ArrayList<>(); // comment 생성자 생성
    private Comment_Adapter Comment_Adapter; // comment view에 찍힐거를 땡겨옴
    private ListView a;// listview  변수
    int id;// id를 넘기는용

    public comment_Tab(int i){
        id = i;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.comment,container,false);
        //comment_Listview를 view에 띄움
        a = rootView.findViewById(R.id.Comment_ListView);
        //commnet_item를 파싱해 comment_listview에 띄움
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Comment_Item item = new Comment_Item(obj.getInt("pid"),obj.getInt("id"),obj.getString("subtitle"),obj.getString("owner"),obj.getString("createDate"),obj.getString("password"));
                        comment_items.add(item);
                    }
                    Log.e("확인확인",""+response);
                    Comment_Adapter = new Comment_Adapter(getContext(),comment_items);
                    a.setAdapter(Comment_Adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        //서버로 호출
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        //comment 창을 response
        DBResponse.searchCommentResponse(requestQueue,id,responseListener);

        return rootView;
    }
}
