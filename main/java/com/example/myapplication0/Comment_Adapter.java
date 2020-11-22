package com.example.myapplication0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Comment_Adapter extends ArrayAdapter {

    private Context context;
    private List<Comment_Item> list;

    public Comment_Adapter(Context context, ArrayList list){
        super(context,0,list);
        this.context = context;
        this.list = list;

    }

    class ViewHolder{
        TextView id;
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
            convertView = layoutInflater.inflate(R.layout.detail_listdata,parent,false);
        }

        viewHolder = new ViewHolder();
        viewHolder.id = (TextView)convertView.findViewById(R.id.d_id);
        viewHolder.subtitle = (TextView)convertView.findViewById(R.id.d_subtitle);
        viewHolder.owner = (TextView)convertView.findViewById(R.id.d_owner);
        viewHolder.createDate = (TextView)convertView.findViewById(R.id.d_createDate);

        final Comment_Item comment_item = (Comment_Item)list.get(position);

        viewHolder.id.setText(""+comment_item.getId());
        viewHolder.subtitle.setText(comment_item.getSubtitle());
        viewHolder.owner.setText(comment_item.getOwner());
        viewHolder.createDate.setText(comment_item.getCreateDate());

        return convertView;


    }
}
