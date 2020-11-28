package com.slave_mk14.libraryuserrecommendation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.ViewHolder> {
    private ArrayList<Book> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBook.ViewHolder holder, int position) {
        holder.onBind(list.get(position), position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void addItem(ArrayList data) {
        list = data;
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView publisher;
        TextView author;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.bookname);
            publisher = itemView.findViewById(R.id.bookpublisher);
            author = itemView.findViewById(R.id.bookauthor);
        }

        void onBind(Book book, int position){
            name.setText((position+1)+"★, "+ book.getName());
            publisher.setText(book.getPublisher());
            author.setText(book.getAuthor());
        }
    }
}
