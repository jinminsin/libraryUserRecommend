package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentListFragment extends Fragment {

    private AdapterComment adapter;
    private RecyclerView list;
    private int id;
    private RequestQueue requestQueue;
    private Response.Listener<String> responseListener;

    public CommentListFragment(int pid){
        id = pid;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_commentlist,container,false);
        list = rootView.findViewById(R.id.CommentList);
        requestQueue = Volley.newRequestQueue(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        list.setLayoutManager(linearLayoutManager);

        responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Comment item = new Comment(obj.getInt("seedid"),obj.getInt("pid"),obj.getInt("id"),obj.getString("subtitle"),obj.getString("owner"),obj.getString("createDate"));
                        adapter.addItem(item);
                    }
                    list.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        adapter = new AdapterComment(getContext());
        DBResponse.searchCommentResponse(requestQueue,id,responseListener);

        return rootView;
    }
}