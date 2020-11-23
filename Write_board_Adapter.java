package com.example.writelistviewtest;

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

public class Write_board_Adapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List<Board_Item> list;



    public Write_board_Adapter( Context context, int resource, ArrayList list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context," ",Toast.LENGTH_SHORT).show();
    }

    class ViewHolder{
        public TextView subtitle;
        public TextView id;
        public TextView writer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.writing_baord_listdata,parent,false);
        }

        viewHolder = new ViewHolder();
        viewHolder.id = (TextView)convertView.findViewById(R.id.w_uid);
        viewHolder.writer = (TextView)convertView.findViewById(R.id.w_writer);
        viewHolder.subtitle = (TextView)convertView.findViewById(R.id.subtitle);

        final Board_Item w_item = (Board_Item)list.get(position);
        viewHolder.id.setText(""+w_item.getId());
        viewHolder.subtitle.setText(w_item.getSubtitle());
        viewHolder.writer.setText(w_item.getWriter());

        return convertView;
    }


}
