package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class CommentListFragment extends Fragment {

    private ArrayList<Comment> list = new ArrayList<>();
    private AdapterComment adapter;
    private ListView listView;
    private int id;

    public CommentListFragment(int pid){
        id = pid;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_commentlist,container,false);
        listView = rootView.findViewById(R.id.Comment_ListView);
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Comment item = new Comment(obj.getInt("pid"),obj.getInt("id"),obj.getString("subtitle"),obj.getString("owner"),obj.getString("createDate"),obj.getString("password"));
                        list.add(item);
                    }
                    adapter = new AdapterComment(getContext(),list);
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        DBResponse.searchCommentResponse(requestQueue,id,responseListener);

        return rootView;
    }
}
