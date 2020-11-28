package com.slave_mk14.libraryuserrecommendation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

public class SettingFragment extends Fragment {
    private TextView mUserId,mLikeCode, mSiblingLikeCode;
    private Button rBtn;
    private RequestQueue requestQueue;
    private Response.Listener<String> resetListener;
    private boolean state = true;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting,container,false);

        mUserId = rootView.findViewById(R.id.mUserid);
        mLikeCode = rootView.findViewById(R.id.mUserlikeCode);
        mSiblingLikeCode = rootView.findViewById(R.id.mUsersiblingLikeCode);
        rBtn = rootView.findViewById(R.id.reBtn);


        mUserId.setText(MainActivity.mUser.getId());
        mLikeCode.setText(DataHashmap.BookCodetoBookHash.get(MainActivity.mUser.getLikeBookCode()));
        mSiblingLikeCode.setText(DataHashmap.BookCodetoBookHash.get(MainActivity.mUser.getSiblingLikeBookCode()));

        requestQueue = Volley.newRequestQueue(getContext());

        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.mUser.getLikeBookCode().equals("-1")){
                    Toast.makeText(getContext(),"조사를 하지 않으셨어요.",Toast.LENGTH_SHORT).show();
                }
                else if(state) {
                    state = false;
                    DBResponse.resetBookCodeResponse(requestQueue, MainActivity.mUser.getSeedid(), resetListener);
                }
            }
        });
        resetListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("1")){
                    MainActivity.mUser.saveLikeBookCode("-1","-1");
                    MainActivity.fManager.resetTestResultFragment(SettingFragment.this);
                }
                state = true;
            }
        };

        return rootView;
    }
}
