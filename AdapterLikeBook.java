package com.slave_mk14.libraryuserrecommendation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterLikeBook extends ArrayAdapter {

    private Context context;
    private ArrayList<LikeBook> list;

    public AdapterLikeBook(Context context,ArrayList list){
        super(context,0,list);
        this.context = context;
        this.list = list;
    }

    class ViewHolder{
        TextView bookTypeTitle;
        ListView booklist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final AdapterLikeBook.ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.likebooklist, parent, false);
        }

        viewHolder = new AdapterLikeBook.ViewHolder();
        viewHolder.bookTypeTitle = convertView.findViewById(R.id.likeBookTypeTitle);
        viewHolder.booklist = convertView.findViewById(R.id.bookList);

        LikeBook likebook = list.get(position);

        viewHolder.bookTypeTitle.setText(likebook.getTitle());

        AdapterBook adapter = new AdapterBook(getContext(), likebook.getBook());
        viewHolder.booklist.setAdapter(adapter);


        return convertView;
    }
}
