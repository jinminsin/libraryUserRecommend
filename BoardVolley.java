package com.example.myapplication;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class BoardVolley {
    //singleton pattern

    private RequestQueue requestQueue;
    private static BoardVolley instance;

    public BoardVolley(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public static BoardVolley getInstance(Context context){
        if(instance == null)
            instance = new BoardVolley(context);
        return null;

    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }

}

