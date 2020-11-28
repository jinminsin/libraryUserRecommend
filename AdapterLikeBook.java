package com.slave_mk14.libraryuserrecommendation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLikeBook extends RecyclerView.Adapter<AdapterLikeBook.ViewHolder> {
    private ArrayList<LikeBook> list = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    @NonNull
    @Override
    public AdapterLikeBook.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.likebooklist, parent, false);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        return new AdapterLikeBook.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLikeBook.ViewHolder holder, int position) {
        holder.onBind(list.get(position), position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void addItem(LikeBook data) {
        list.add(data);
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        RecyclerView bookList;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.likeBookCodeTitle);
            bookList = itemView.findViewById(R.id.booklist);
        }

        void onBind(LikeBook book, int position){
                title.setText(book.getTitle());
                bookList.setLayoutManager(linearLayoutManager);
                AdapterBook adapter = new AdapterBook();
                adapter.addItem(book.getBook());
                bookList.setAdapter(adapter);
        }
    }
}
