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

public class CommunityListFragment extends Fragment {

    private RecyclerView list;
    private AdapterCommunity adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_communitylist,container,false); //view 띄움
        list = rootView.findViewById(R.id.CommunityList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        list.setLayoutManager(linearLayoutManager);

        adapter = new AdapterCommunity(this);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Community item = new Community(obj.getString("name"),obj.getString("detail"),obj.getString("owner"),obj.getString("createDate"));
                        adapter.addItem(item);
                    }
                    list.setAdapter(adapter);
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