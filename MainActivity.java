package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText login_id, login_pw;
    private Button login_button, join_button;

    //로그인 화면
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_id = findViewById(R.id.ID);
        login_pw = findViewById(R.id.PW);
        join_button = findViewById(R.id.joinbtn);
        login_button = findViewById(R.id.loginbtn);

        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Join.class);
                startActivity(intent);
            }
        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = login_id.getText().toString();
                String userPW = login_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                String userID = jsonObject.getString("userID");
                                String userPW = jsonObject.getString("userPW");
                                Toast.makeText(getApplicationContext(), String.format("%s님 환영합니다"),Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPW", userPW);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "로그인에 실패",Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID,userPW, responseListener, null);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
        });





    }
}










