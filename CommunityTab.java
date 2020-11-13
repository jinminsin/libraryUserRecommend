package com.example.myapplication0;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class CommunityTab extends Fragment {

    private String owner = "도현태";
    private String title ="Fantasy";


    ArrayList<Board_Item> item;
    ListView customListView;
    private static Community_Adapter Community_Adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.community_main, container, false);

        //data를 가져와서 adapter랑 연결
        item = new ArrayList<>();
        item.add(new Board_Item(0,title,owner,null,null,null));
        item.add(new Board_Item(0,"lightNovel","성진용",null,null,null));
        item.add(new Board_Item(0,"math","오승환",null,null,null));
        item.add(new Board_Item(0,"manga","김명환",null,null,null));

        customListView = (ListView) rootView.findViewById(R.id.listView_Custom);
        Community_Adapter = new Community_Adapter(getContext(),0,item);
        customListView.setAdapter(Community_Adapter);// listview 연결



        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Board_Item item = (Board_Item)parent.getItemAtPosition(position);
                int c_id = item.getId(); // item의 getId를 getItemAtPosition으로 받아옴




            }
        });




        return rootView;
    }

}