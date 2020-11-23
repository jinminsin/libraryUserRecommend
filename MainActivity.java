package com.slave_mk14.libraryuserrecommendation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static FragmentHelper fManager = new FragmentHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tab = findViewById(R.id.tab);

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);

        for(int index = 0; index < 4; index++)
            tab.getTabAt(index).setIcon(images.get(index));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //do stuff here
                fManager.moveFragment(tab.getPosition(), R.id.yeah,MainActivity.this);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}