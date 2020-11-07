package com.example.writelistviewtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Community_Adapter extends ArrayAdapter implements AdapterView.OnItemClickListener {


    private Context context;// context 저장
    private List<Board_Item> list; // data list

    public Community_Adapter( Context context, int resource, ArrayList list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
        Toast.makeText(context, "community", Toast.LENGTH_SHORT).show();
    }

    class ViewHolder{
        public TextView id;
        public TextView owner;
        public TextView title;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.community_listdata,parent,false);
        }

        viewHolder = new ViewHolder();
        viewHolder.id = (TextView)convertView.findViewById(R.id.uid);
        viewHolder.title = (TextView)convertView.findViewById(R.id.title);
        viewHolder.owner = (TextView)convertView.findViewById(R.id.owner);

        final Board_Item board_item = (Board_Item)list.get(position);
        viewHolder.id.setText(""+ board_item.getId());
        viewHolder.owner.setText(board_item.getOwner());
        viewHolder.title.setText(board_item.getTitle());



        return convertView;
    }
}