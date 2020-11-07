package com.example.writelistviewtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Write_borad extends Fragment {
    ArrayList<Board_Item> w_item;
    ListView customListView_2;
    private static Write_board_Adapter write_board_adapter;
    private int id =1;
    private String subtitle ="프리코네 뭐하누";
    private String writer = "키무라";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.writingboard_fragment_data, container, false);

        w_item = new ArrayList<>();
        w_item.add(new Board_Item(id,null,null,null,subtitle,writer));
        w_item.add(new Board_Item(2,null,null,null,"쥬얼뿌린다","갓카오"));
        w_item.add(new Board_Item(3,null,null,null,"삼붕이","삼갤"));

        customListView_2 = (ListView)rootView.findViewById(R.id.listView_Custom_2);
        write_board_adapter = new Write_board_Adapter(getContext(),0,w_item);
        customListView_2.setAdapter(write_board_adapter);
        customListView_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Board_Item item = (Board_Item)parent.getItemAtPosition(position);
                int w_id = getId();
            }
        });


        return rootView;
    }

}
