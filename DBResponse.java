package com.slave_mk14.libraryuserrecommendation;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class DBResponse {
    String URL = "http://192.168.123.105:80/";
    void response(Context context, String mode, String id, String pw, Response.Listener<String> listener){
        userDBResponse res = new userDBResponse(URL+mode+".php",mode,id,pw,listener);
        RequestQueue q = Volley.newRequestQueue(context);
        q.add(res);
    }

    class userDBResponse extends StringRequest {
        private Map<String, String> map;

        public userDBResponse(String url, String mode, String id, String pw, Response.Listener<String> listener) {
            super(Request.Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("u_id", id);
            map.put("u_pw", pw);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return map;
        }
    }
}