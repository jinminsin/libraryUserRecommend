package com.slave_mk14.libraryuserrecommendation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.ViewHolder> {
    private ArrayList<Comment> list = new ArrayList<>();
    private Popup dialog;
    private Context context;
    private View.OnClickListener okClick, noClick;

    public AdapterComment(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public AdapterComment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment, parent, false);
        return new AdapterComment.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterComment.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void addItem(Comment data) {
        list.add(data);
    }

    void clearItem(){
        list.clear();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView commentSubTitle, commentOwner, commentCreateDate;
        Button delBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            commentSubTitle = itemView.findViewById(R.id.d_subtitle);
            commentCreateDate = itemView.findViewById(R.id.d_createDate);
            commentOwner = itemView.findViewById(R.id.d_owner);
            delBtn = itemView.findViewById(R.id.delBtn);
        }

        void onBind(final Comment data) {
            commentSubTitle.setText(data.getSubtitle());
            commentCreateDate.setText(data.getCreateDate());
            commentOwner.setText(data.getOwner());
            if(MainActivity.mUser.getSeedid() != data.getSeedid()) delBtn.setVisibility(View.INVISIBLE);
            else
            {
                okClick = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        DBResponse.deleteCommentResponse(Volley.newRequestQueue(context),MainActivity.mUser.getSeedid(),data.getId(),new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.equals("1"))
                                {
                                    list.remove(data);
                                    AdapterComment.this.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                };

                noClick = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                };

                delBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog = new Popup(context,okClick,noClick);
                        dialog.show();
                    }
                });
            }
        }
    }
}