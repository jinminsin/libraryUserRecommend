package com.slave_mk14.libraryuserrecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //이것은 임시로 만들어놓은 로그인 기능임 -> 나중에 고칠것


        EditText userID, userPW;
        Button loginBtn;
        String logid, logpw;
        SharedPreferences pref;
        SharedPreferences.Editor editor;

        final EditText ID = (EditText) findViewById(R.id.ID);
        final EditText PW = (EditText) findViewById(R.id.PW);
        Button button = (Button)findViewById(R.id.loginbtn);
        Button button2 = (Button) findViewById(R.id.signupbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int id = ID.getText().toString().length();
                final int pw = PW.getText().toString().length();

                if(id>0 && pw>0){ // -> on (1)
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                // ID와 PW 둘 다 입력하면 넘어감
                else{ // -> off )(0)
                    Toast.makeText(LogInActivity.this, "ID,PW를 입력하시오",Toast.LENGTH_SHORT).show();
                }
            }
            //ID와 PW 두개 중 한개라도 입력하지 않으면 넘어가지 않음


        });
    }
}