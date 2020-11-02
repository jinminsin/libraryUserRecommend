package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BoardAdapter extends BaseAdapter {
    private Context context; //컨텍스트 저장
    private List<Board> boardList;//게시판 리스트

    public BoardAdapter(ArrayList<Board> boardList) {
        this.boardList = boardList; //boardlist 생성자
    }

    @Override
    public int getCount() {
        return boardList.size();
    }

    @Override
    public Object getItem(int position) {
        return boardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final int pos = position; // ListView 위치(첫 번째 = 0)
        final Context context = viewGroup.getContext();
        Board board = boardList.get(position);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.board_listview,viewGroup,false);
        }

        TextView title = (TextView)view.findViewById(R.id.title);
        TextView owner = (TextView)view.findViewById(R.id.owner);
        TextView id = (TextView)view.findViewById(R.id.id);



        title.setText(board.getTitle());//title 연결
        owner.setText(board.getOwner());
        id.setText(board.getId());

        return view;
    }
}


