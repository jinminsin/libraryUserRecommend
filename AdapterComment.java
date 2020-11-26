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

public class AdapterComment extends ArrayAdapter {

    private Context context;
    private ArrayList<Comment> list;

    public AdapterComment(Context context, ArrayList list){
        super(context,0,list);
        this.context = context;
        this.list = list;

    }

    class ViewHolder{
        TextView subtitle;
        TextView owner;
        TextView createDate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.comment,parent,false);
        }

        viewHolder = new ViewHolder();
        viewHolder.subtitle = (TextView)convertView.findViewById(R.id.d_subtitle);
        viewHolder.owner = (TextView)convertView.findViewById(R.id.d_owner);
        viewHolder.createDate = (TextView)convertView.findViewById(R.id.d_createDate);

        final Comment comment_item = (Comment)list.get(position);

        viewHolder.subtitle.setText(comment_item.getSubtitle());
        viewHolder.owner.setText(comment_item.getOwner());
        viewHolder.createDate.setText(comment_item.getCreateDate());

        return convertView;


    }
}
