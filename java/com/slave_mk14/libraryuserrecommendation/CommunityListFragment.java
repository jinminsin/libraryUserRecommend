package com.slave_mk14.libraryuserrecommendation;

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

public class CommunityListFragment extends Fragment {

    ArrayList<Community> community_items; // 생성자 생성
    ListView community_listView;
    private static AdapterCommunity Community_Adapter;


    //커뮤니티 목록 띄우는곳


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_communitylist,container,false); //view 띄움
        community_listView = (ListView)rootView.findViewById(R.id.Community_ListView);
        community_items = new ArrayList<>();

        final Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonObject.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Community item = new Community(obj.getString("name"),obj.getString("detail"),obj.getString("owner"),obj.getString("createDate"));
                        community_items.add(item);
                        Log.e("확인확인",""+item.getName());
                    }

                    Community_Adapter = new AdapterCommunity(getContext(), community_items);
                    community_listView.setAdapter(Community_Adapter);

                    community_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            MainActivity.fManager.goPostFragment(position+1,R.id.contentFragment, CommunityListFragment.this);
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
