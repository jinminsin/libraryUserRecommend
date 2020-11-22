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

public class Post_Adapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List<Post_Item> list;

    public Post_Adapter(Context context, ArrayList list){
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //TODO
    }

    class ViewHolder{
        TextView title;
        TextView createDate;
        TextView subtitle;
        TextView cid;
        TextView owner;
        TextView password;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.post_listdata,parent,false);
        }
        viewHolder = new ViewHolder();
        viewHolder.title = (TextView)convertView.findViewById(R.id.p_title);
        viewHolder.owner = (TextView)convertView.findViewById(R.id.p_owner);
        viewHolder.createDate = (TextView)convertView.findViewById(R.id.p_createDate);

        final Post_Item post_item = (Post_Item)list.get(position);
        viewHolder.title.setText(post_item.getTitle());
        viewHolder.owner.setText(post_item.getOwner());
        viewHolder.createDate.setText(post_item.getCreateDate());
        return convertView;
    }
}