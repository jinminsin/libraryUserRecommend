package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.database.sqlite.*;
import java.util.ArrayList;

public class Community extends AppCompatActivity {

    private final int id = 1;
    private final String title = "테스트 커뮤니티";
    private final String owner = "도현태";
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        ListView a = (ListView) findViewById(R.id.communityList);
        ArrayList<Board> boardList = new ArrayList<>();
        //DB존
        /*      DB에서 Community 데이터를 받아서, add를 통해 ListAdapter에 연결
         *                                                                     */
        //DB존
        boardList.add(new Board(id,title,owner));
        BoardAdapter b = new BoardAdapter(boardList);
        a.setAdapter(b);


        button = (Button)findViewById(R.id.create_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WritingBoard.class);
                startActivity(intent);
            }
        });

        }


    }





