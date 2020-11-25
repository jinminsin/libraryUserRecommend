package com.slave_mk14.libraryuserrecommendation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static FragmentHelper fManager;
    static User mUser = null;
    static TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivityForResult(new Intent(this, LogInActivity.class), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        setMainView();
    }

    public void setMainView(){
        tab = findViewById(R.id.tab);

        fManager = new FragmentHelper();
        fManager.initialFragment(this);

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.home);
        images.add(R.drawable.search);
        images.add(R.drawable.bell);
        images.add(R.drawable.setting);

        for(int index = 0; index < 4; index++)
            tab.getTabAt(index).setIcon(images.get(index));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                    fManager.moveFragment(tab.getPosition(), R.id.contentFragment,MainActivity.this);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                    fManager.moveFragment(tab.getPosition(), R.id.contentFragment,MainActivity.this);
            }
        });
    }
}