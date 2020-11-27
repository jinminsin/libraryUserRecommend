package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class PostListFragment extends Fragment {
    private RecyclerView list;
    private AdapterPost adapter;
    private TextView title;
    private int id;
    private String name;

    public PostListFragment(int cid, String name){
        id = cid;
        this.name = name;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_postlist,container,false);
        title = rootView.findViewById(R.id.postTitle);
        list = rootView.findViewById(R.id.PostList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        list.setLayoutManager(linearLayoutManager);

        adapter = new AdapterPost(this);

        title.setText(name);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Post item = new Post(obj.getInt("seedid"), obj.getInt("cid"),obj.getInt("id"),obj.getString("title"),obj.getString("subtitle"),obj.getString("owner"),obj.getString("createDate"));
                        adapter.addItem(item);
                    }
                    list.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        DBResponse.searchPostResponse(requestQueue,id,responseListener);

        return rootView;
    }
}