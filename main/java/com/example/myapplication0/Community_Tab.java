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

public class Community_Tab extends Fragment {

    ArrayList<Community_Item> community_items = new ArrayList<>();
    ListView community_listView;
    private static Community_Adapter Community_Adapter;
    private static String url = "http://39.112.64.186/";

//커뮤니티 목록 띄우는곳


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.community_main,container,false);
        community_listView = (ListView)rootView.findViewById(R.id.Community_ListView);

        final Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String Community = "{\"result\" : [{\"name\":\"name\",\"detail\":\"detail\",\"owner\":\"owner\",\"createDate\":\"createDate\"}]}";
                try {
                    JSONObject jsonObject = new JSONObject(Community);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonObject.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Community_Item item = new Community_Item(obj.getString("name"),obj.getString("detail"),obj.getString("owner"),obj.getString("createDate"));
                        community_items.add(item);
                        Log.e("확인확인",""+item.getName());
                    }

                    Community_Adapter = new Community_Adapter(getContext(),0,community_items);
                    community_listView.setAdapter(Community_Adapter);

                    community_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Community_Item item = (Community_Item)parent.getItemAtPosition(position);
                            getFragmentManager().beginTransaction().replace(R.id.yeah, new Post_Tab(position)).commit();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        DBResponse.searchCommunityResponse(requestQueue,responseListener);

        return rootView;

    }
}
