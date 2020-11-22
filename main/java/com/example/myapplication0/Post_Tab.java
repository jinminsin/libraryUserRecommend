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

//게시글이 나오는곳

public class Post_Tab extends Fragment {
    ArrayList<Post_Item> post_items = new ArrayList<>();
    ListView post_listView;
    private static Post_Adapter Post_Adapter;
    int id;

    public Post_Tab(int i){
        id = i;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.community_post,container,false);
        post_listView = (ListView)rootView.findViewById(R.id.Post_ListView);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Post_Item item = new Post_Item(obj.getInt("cid"),obj.getInt("id"),obj.getString("title"),obj.getString("subtitle"),obj.getString("owner"),obj.getString("createDate"),obj.getString("password"));
                        post_items.add(item);
                    }
                    Log.e("확인확인",""+response);
                    Log.e("확인확인",""+jsonArray.getJSONObject(0).getInt("cid"));
                    Post_Adapter = new Post_Adapter(getContext(),post_items);
                    post_listView.setAdapter(Post_Adapter);
                    post_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Post_Item item = (Post_Item)parent.getItemAtPosition(position);
                            getFragmentManager().beginTransaction().replace(R.id.yeah, new Post_Detail_Tab(item)).commit();
                        }
                    });
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


