package com.slave_mk14.libraryuserrecommendation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCommunity extends RecyclerView.Adapter<AdapterCommunity.ViewHolder>  {
    private ArrayList<Community> list = new ArrayList<>();
    private CommunityListFragment fragment;

    public AdapterCommunity(CommunityListFragment fragment){
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public AdapterCommunity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.communitylist, parent, false);
        return new AdapterCommunity.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCommunity.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void addItem(Community data) {
        list.add(data);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView communityName, communityCreateDate, communityDetail, communityOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.fManager.goPostFragment(getAdapterPosition() + 1, list.get(getAdapterPosition()).getName(), R.id.contentFragment, fragment);
                }
            });

            communityName = itemView.findViewById(R.id.c_name);
            communityCreateDate = itemView.findViewById(R.id.c_createDate);
            communityDetail = itemView.findViewById(R.id.c_detail);
            communityOwner = itemView.findViewById(R.id.c_owner);
        }

        void onBind(Community data){
            communityName.setText(data.getName());
            communityOwner.setText(data.getOwner());
            communityDetail.setText(data.getDetail());
            communityCreateDate.setText(data.getCreateDate());
        }
    }
}
