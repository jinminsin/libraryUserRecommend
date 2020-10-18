package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText userID, userPW;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomTask task = new CustomTask();
        task.execute("root", "1234");
        userID = (EditText) findViewById(R.id.ID);
        userPW = (EditText) findViewById(R.id.PW);
        loginBtn = (Button) findViewById(R.id.loginbtn);
        loginBtn.setOnClickListener(loginBtnlistener);

    }

    class CustomTask extends AsyncTask<String, Void, String> {
        String sendmsg, receivemsg;

        @Override
        protected String doInBackground(String... strings) {

            try {
                boolean str;
                URL url = new URL("임의의URL을 정해야함");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-from-urlencoded");
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendmsg = "id=" + strings[0] + "&pwd" + strings[1];
                osw.write(sendmsg);
                osw.flush();
                if (conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    while ((str = reader.readLine() != null)) {
                        buffer.append(str);
                    }
                    receivemsg = buffer.toString();
                } else {
                    Log.i("통신결과", conn.getResponseCode() + "에러");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receivemsg;
        }
    }

    View.OnClickListener loginBtnlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.loginbtn:
                    String loginid = userID.getText().toString();
                    String loginpw = userPW.getText().toString();
                    try {
                        String result = new CustomTask().execute(loginid, loginpw, "login").get();
                        if (result.equals("true")) {
                            Toast.makeText(MainActivity.this, "로그인", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, DB_activity.class);
                            startActivity(intent);
                            finish();
                        } else if (result.equals("false")) {
                            Toast.makeText(MainActivity.this, "id,pw틀림", Toast.LENGTH_SHORT).show();
                            userID.setText("");
                            userPW.setText("");
                        } else if (result.equals("nonid")) {
                            Toast.makeText(MainActivity.this, "존재않는아이디", Toast.LENGTH_SHORT).show();
                            userID.setText("");
                            userPW.setText("");
                        }
                    } catch (Exception e) {
                    }
                    break;
            }
        }
    };
}









