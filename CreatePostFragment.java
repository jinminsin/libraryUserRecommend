package com.slave_mk14.libraryuserrecommendation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePostFragment extends Fragment {
    private int cid;
    private EditText title, subtitle;
    private Button enrollBtn, exitBtn;
    private RequestQueue requestQueue;
    private Response.Listener<String> listener;
    private boolean state = true;

    public CreatePostFragment(int cid){
        this.cid = cid;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_createpost,container,false);

        title = rootView.findViewById(R.id.createPostTitle);
        subtitle = rootView.findViewById(R.id.createPostSubtitle);
        enrollBtn = rootView.findViewById(R.id.postEnrollBtn);
        exitBtn = rootView.findViewById(R.id.createCancelBtn);

        requestQueue = Volley.newRequestQueue(container.getContext());

        listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("",response);
                if(response.equals("1")){
                    MainActivity.fManager.endCreatePostFragment(R.id.contentFragment, CreatePostFragment.this);
                }
                state = true;
            }
        };

        enrollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!state) return;

                if(title.getText().length() > 0 && subtitle.getText().length() > 0)
                {
                    state = false;
                    Post post = new Post(MainActivity.mUser.getSeedid(), cid, title.getText().toString(), subtitle.getText().toString(),
                            MainActivity.mUser.getAuthority() == 1 ? "운영자" : MainActivity.mUser.getId(),
                            new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
                    DBResponse.addPostResponse(requestQueue,post,listener);
                }else
                {
                    Toast.makeText(getContext(),"제목과 내용을 모두 적어주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fManager.endCreatePostFragment(R.id.contentFragment,CreatePostFragment.this);
            }
        });

        return rootView;
    }
}