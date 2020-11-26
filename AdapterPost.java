package com.slave_mk14.libraryuserrecommendation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.ViewHolder> {
    private ArrayList<Post> list = new ArrayList<>();
    private PostListFragment fragment;

    public AdapterPost(PostListFragment fragment) {
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public AdapterPost.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postlist, parent, false);
        return new AdapterPost.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPost.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void addItem(Post data) {
        list.add(data);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView postTitle, postCreateDate, postOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.fManager.goPostContentFragment(list.get(getAdapterPosition()), R.id.contentFragment, fragment);
                }
            });

            postTitle = itemView.findViewById(R.id.p_title);
            postCreateDate = itemView.findViewById(R.id.p_createDate);
            postOwner = itemView.findViewById(R.id.p_owner);
        }

        void onBind(Post data) {
            postTitle.setText(data.getTitle());
            postCreateDate.setText(data.getCreateDate());
            postOwner.setText(data.getOwner());
        }
    }
}


