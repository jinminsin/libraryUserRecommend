package com.slave_mk14.libraryuserrecommendation;

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
    private Button backBtn, insertCommentBtn;
    private RequestQueue requestQueue;
    private Response.Listener<String> searchCommentListener, addCommentListener;
    private boolean state = true;

    private AdapterComment adapter;
    private RecyclerView list;

    private EditText comment;

    public PostContentFragment(Post content){
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_postcontent,container,false);
        title= rootView.findViewById(R.id.postContentTitle);//title
        owner= rootView.findViewById(R.id.postContentOwner);//owner
        createDate= rootView.findViewById(R.id.postContentCreateDate);//createDate
        subtitle= rootView.findViewById(R.id.postContentSubtitle);//subtitle
        backBtn = rootView.findViewById(R.id.bBtn);

        comment = rootView.findViewById(R.id.createComment);
        insertCommentBtn = rootView.findViewById(R.id.commitBtn);

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

        insertCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comment.getText().length() > 0 && state) {
                    state = false;
                    Comment newComment = new Comment(MainActivity.mUser.getSeedid(),
                            content.getId(), comment.getText().toString(), MainActivity.mUser.getId(),
                            new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));

                    DBResponse.addCommentResponse(requestQueue, newComment, addCommentListener);
                    comment.setText("");
                }
            }
        });

        list = rootView.findViewById(R.id.CommentList);
        requestQueue = Volley.newRequestQueue(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        list.setLayoutManager(linearLayoutManager);

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
        adapter = new AdapterComment(getContext());
        DBResponse.searchCommentResponse(requestQueue,content.getId(),searchCommentListener);

        return rootView;
    }

}
