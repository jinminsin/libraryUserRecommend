package com.example.myapplication;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

public class RegisterRequest extends StringRequest{
    //회원가입 요청
    final static private String URL = "login.php";
    private Map<String, String> map;

    public RegisterRequest(String id, String pw, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("id", id);
        map.put("pw", pw);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}