package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
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


public class PostListFragment extends Fragment {
    private ArrayList<Post> list;
    private ListView listView;
    private AdapterPost adapter;
    private int id;

    public PostListFragment(int cid){
        id = cid;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_postlist,container,false);
        listView = (ListView)rootView.findViewById(R.id.Post_ListView);
        list = new ArrayList<>();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Post item = new Post(obj.getInt("cid"),obj.getInt("id"),obj.getString("title"),obj.getString("subtitle"),obj.getString("owner"),obj.getString("createDate"),obj.getString("password"));
                        list.add(item);
                    }

                    adapter = new AdapterPost(getContext(),list);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Post item = (Post)parent.getItemAtPosition(position);
                            MainActivity.fManager.goPostContentFragment(item,R.id.contentFragment, PostListFragment.this);
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