package com.example.myapplication0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Community_Adapter extends ArrayAdapter implements AdapterView.OnItemClickListener {
    private Context context;
    private List<Community_Item> list;

    public Community_Adapter(Context context, int resource, ArrayList list){
        super(context,0,list);
        this.context = context;
        this.list = list;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //TODO
    }

    class ViewHolder{
        TextView name;
        TextView owner;
        TextView detail;
        TextView createDate;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.community_listdata,parent,false);
        }

        viewHolder = new ViewHolder();
        viewHolder.name = (TextView)convertView.findViewById(R.id.c_name);
        viewHolder.detail = (TextView)convertView.findViewById(R.id.c_detail);
        viewHolder.owner = (TextView)convertView.findViewById(R.id.c_owner);
        viewHolder.createDate = (TextView)convertView.findViewById(R.id.c_createDate);

        final Community_Item community_item = (Community_Item)list.get(position);

        viewHolder.createDate.setText(community_item.getCreateDate());
        viewHolder.name.setText(community_item.getName());
        viewHolder.owner.setText(community_item.getOwner());
        viewHolder.detail.setText(community_item.getDetail());

        return convertView;


    }
}
