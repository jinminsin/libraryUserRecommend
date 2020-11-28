package com.slave_mk14.libraryuserrecommendation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostContentFragment extends Fragment {

    private TextView title, owner, createDate, subtitle;
    private Post content;
    private Button backBtn, insertCommentBtn, delPostBtn;
    private RequestQueue requestQueue;
    private Response.Listener<String> searchCommentListener, addCommentListener, deletePostListener;
    private boolean state = true;

    private AdapterComment adapter;
    private RecyclerView list;

    private EditText comment;

    private Popup dialog;
    private View.OnClickListener okClick, noClick;

    public PostContentFragment(Post content){
        this.content = content;
    }

    public void initialize(View rootView){
        title= rootView.findViewById(R.id.postContentTitle);//title
        owner= rootView.findViewById(R.id.postContentOwner);//owner
        createDate= rootView.findViewById(R.id.postContentCreateDate);//createDate
        subtitle= rootView.findViewById(R.id.postContentSubtitle);//subtitle

        comment = rootView.findViewById(R.id.createComment);

        backBtn = rootView.findViewById(R.id.bBtn);
        delPostBtn = rootView.findViewById(R.id.delPostBtn);

        insertCommentBtn = rootView.findViewById(R.id.commitBtn);

        title.setText(content.getTitle());
        owner.setText(content.getOwner());
        createDate.setText(content.getCreateDate());
        subtitle.setText(content.getSubtitle());

        if(MainActivity.mUser.getSeedid() != content.getSeedid()) delPostBtn.setVisibility(View.INVISIBLE);
        else {
            okClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    DBResponse.deletePostResponse(requestQueue,MainActivity.mUser.getSeedid(),content.getId(), deletePostListener);
                }
            };

            noClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            };

            delPostBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog = new Popup(getContext(), okClick, noClick);
                    dialog.show();
                }
            });
        }

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity.fManager.endPostContentFragment(R.id.contentFragment,PostContentFragment.this);
            }
        });

        insertCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comment.getText().length() > 0 && state) {
                    state = false;
                    Comment newComment = new Comment(MainActivity.mUser.getSeedid(),
                            content.getId(), comment.getText().toString(), MainActivity.mUser.getAuthority() == 1 ? "운영자" : MainActivity.mUser.getId(),
                            new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));

                    DBResponse.addCommentResponse(requestQueue, newComment, addCommentListener);
                    comment.setText("");
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_postcontent,container,false);
        initialize(rootView);

        list = rootView.findViewById(R.id.CommentList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        list.setLayoutManager(linearLayoutManager);

        requestQueue = Volley.newRequestQueue(container.getContext());
        adapter = new AdapterComment(container.getContext());

        addCommentListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("1")){
                    adapter.clearItem();
                    DBResponse.searchCommentResponse(requestQueue,content.getId(),searchCommentListener);
                }
                state = true;
            }
        };

        searchCommentListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Comment item = new Comment(obj.getInt("seedid"),obj.getInt("pid"),obj.getInt("id"),obj.getString("subtitle"),obj.getString("owner"),obj.getString("createDate"));
                        adapter.addItem(item);
                    }
                    list.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        deletePostListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("1")){
                    MainActivity.fManager.endPostContentFragment(R.id.contentFragment,PostContentFragment.this);
                }
            }
        };

        DBResponse.searchCommentResponse(requestQueue,content.getId(),searchCommentListener);

        return rootView;
    }

}
