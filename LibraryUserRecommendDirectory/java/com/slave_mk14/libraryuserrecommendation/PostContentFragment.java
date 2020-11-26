package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PostContentFragment extends Fragment {

    private TextView title, owner, createDate, subtitle;
    private Post content;
    private Button btn;


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
        btn = rootView.findViewById(R.id.bBtn);

        title.setText(content.getTitle());
        owner.setText(content.getOwner());
        createDate.setText(content.getCreateDate());
        subtitle.setText(content.getSubtitle());
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity.fManager.endPostContentFragment(R.id.contentFragment,PostContentFragment.this);
            }
        });

        getFragmentManager().beginTransaction().replace(R.id.commentList,new CommentListFragment(content.getId())).commit();

        return rootView;
    }
}
