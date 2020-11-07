package com.example.writelistviewtest;

import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Community extends Fragment {



    private int id = 1;
    private String owner = "도현태";
    private String title = "Fantasy";

    ArrayList<Board_Item> item;
    ListView customListView;
    private static Community_Adapter Community_Adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.writingboard_fragment_data, container, false);

        //data를 가져와서 adapter랑 연결
        item = new ArrayList<>();
        item.add(new Board_Item(id,title,owner,null,null,null));
        item.add(new Board_Item(2,"lightNovel","성진용",null,null,null));
        item.add(new Board_Item(3,"math","오승환",null,null,null));
        item.add(new Board_Item(4,"manga","김명환",null,null,null));

        customListView = (ListView) rootView.findViewById(R.id.listView_Custom);
        Community_Adapter = new Community_Adapter(getContext(),0,item);
        customListView.setAdapter(Community_Adapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Board_Item item = (Board_Item)parent.getItemAtPosition(position);
               int c_id = item.getId();





            }
        });




        return rootView;
    }
}


