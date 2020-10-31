package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class BoardAdapter extends BaseAdapter {
    private Context context;
    private List<Board> boardList;

    public BoardAdapter(List<Board> boardList) {
        this.boardList = boardList;
    }

    @Override
    public int getCount() {
        return boardList.size();
    }

    @Override
    public Object getItem(int i) {
        return boardList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i; // ListView 위치(첫 번째 = 0)
        context = viewGroup.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater != null)
                view = inflater.inflate(R.layout.listview, viewGroup, false);
        }

        TextView title = view.findViewById(R.id.title),
                date = view.findViewById(R.id.date);

        Board board = boardList.get(i);

        title.setText(board.getTitle());
        date.setText(board.getCreateDate());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 게시글 터치 시 내용 보여주는 다이얼로그 띄우기
                showContent(boardList.get(pos).getTitle(), boardList.get(pos).getContent());
            }
        });

        return view;
    }
        //만드는중
}

