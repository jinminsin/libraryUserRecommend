package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<LikeBook> list;
    private ListView listView;
    private AdapterLikeBook adapter;
    private RequestQueue requestQueue;
    private Response.Listener<String> firstLikeBookListener, secondLikeBookListener;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false); //view 띄움
        listView = (ListView)rootView.findViewById(R.id.likeBookListView);
        list = new ArrayList<>();

        firstLikeBookListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    ArrayList<Book> booklist = new ArrayList<>();
                    Log.e("책책",response);
                    Log.e("숫자 숫자", jsonArray.length()+"");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Book book = new Book(obj.getString("name"), obj.getString("publisher"), obj.getString("author"));
                        booklist.add(book);
                    }

                    LikeBook item = new LikeBook("당신의 원픽! "+DataHashmap.BookCodetoBookHash.get(MainActivity.mUser.getLikeBookCode()),booklist);
                    list.add(item);
                    DBResponse.searchRecommendBookListResponse(requestQueue, MainActivity.mUser.getSiblingLikeBookCode(), secondLikeBookListener);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        secondLikeBookListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    ArrayList<Book> booklist = new ArrayList<>();
                    Log.e("책책",response);
                    Log.e("숫자 숫자", jsonArray.length()+"");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Book book = new Book(obj.getString("name"),obj.getString("publisher"),obj.getString("author"));
                        booklist.add(book);
                    }
                    LikeBook item = new LikeBook("당신의 투픽! "+DataHashmap.BookCodetoBookHash.get(MainActivity.mUser.getSiblingLikeBookCode()),booklist);
                    list.add(item);
                    adapter = new AdapterLikeBook(getContext(),list);
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        requestQueue = Volley.newRequestQueue(getContext());
        DBResponse.searchRecommendBookListResponse(requestQueue, MainActivity.mUser.getLikeBookCode(), firstLikeBookListener);

        return rootView;

    }
}