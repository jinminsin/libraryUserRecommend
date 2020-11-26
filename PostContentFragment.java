package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostContentFragment extends Fragment {

    private TextView title, owner, createDate, subtitle;
    private Post content;
    private Button backBtn, inserCommentBtn;
    private RequestQueue requestQueue;
    private Response.Listener<String> responseListener;
    private CommentListFragment commentListFragment;
    private boolean state = true;

    private EditText comment;

    public PostContentFragment(Post content){
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_postcontent,container,false);
        title= rootView.findViewById(R.id.pd_title);//title
        owner= rootView.findViewById(R.id.pd_owner);//owner
        createDate= rootView.findViewById(R.id.pd_createDate);//createDate
        subtitle= rootView.findViewById(R.id.pd_subtitle);//subtitle
        backBtn = rootView.findViewById(R.id.bBtn);

        comment = rootView.findViewById(R.id.createComment);
        inserCommentBtn = rootView.findViewById(R.id.commitBtn);

        title.setText(content.getTitle());
        owner.setText(content.getOwner());
        createDate.setText(content.getCreateDate());
        subtitle.setText(content.getSubtitle());

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity.fManager.endPostContentFragment(R.id.contentFragment,PostContentFragment.this);
            }
        });


        requestQueue = Volley.newRequestQueue(getContext());

        responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("반응","왔냐?" + response);
                if(response.equals("1")){
                    if(commentListFragment != null) {
                        getFragmentManager().beginTransaction().remove(commentListFragment).commit();
                    }

                    commentListFragment = new CommentListFragment(content.getId());
                    getFragmentManager().beginTransaction().replace(R.id.comment,new CommentListFragment(content.getId())).commit();
                    state = true;
                }
            }
        };

        inserCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comment.getText().length() > 0 && state) {
                    state = false;
                    Comment newComment = new Comment(MainActivity.mUser.getSeedid(),
                            content.getId(), comment.getText().toString(), MainActivity.mUser.getId(),
                            new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));

                    DBResponse.addCommentResponse(requestQueue,newComment,responseListener);
                    comment.setText("");
                }
            }
        });

        commentListFragment = new CommentListFragment(content.getId());
        getFragmentManager().beginTransaction().replace(R.id.comment, commentListFragment).commit();

        return rootView;
    }
}
