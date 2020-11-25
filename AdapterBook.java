package com.slave_mk14.libraryuserrecommendation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterBook extends ArrayAdapter {

    private Context context;
    private ArrayList<Book> list;

    public AdapterBook(Context context, ArrayList list){
        super(context,0,list);
        this.context = context;
        this.list = list;

    }

    class ViewHolder{
        TextView name;
        TextView publisher;
        TextView author;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final AdapterBook.ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.booklist,parent,false);
        }

        viewHolder = new AdapterBook.ViewHolder();
        viewHolder.name = (TextView)convertView.findViewById(R.id.bookname);
        viewHolder.publisher = (TextView)convertView.findViewById(R.id.bookpublisher);
        viewHolder.author = (TextView)convertView.findViewById(R.id.bookauthor);

        final Book book = (Book)list.get(position);

        viewHolder.name.setText((position+1)+"★, "+ book.getName());
        viewHolder.publisher.setText(book.getPublisher());
        viewHolder.author.setText(book.getAuthor());

        return convertView;


    }
}
