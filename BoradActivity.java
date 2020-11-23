package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;

public class BoradActivity extends AppCompatActivity {

    private Context context;
    private ListView listView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borad);
        context = this;
        setContentView(R.layout.activity_borad);
        listView = findViewById(R.id.listView);
        getBoard();
    }

    private void getBoard() {
     setProgressBar(View.VISIBLE);
     final String url = getString(R.string.login);
        RequestQueue queue = BoardVolley.getInstance(context).getRequestQueue();
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                setProgressBar(View.GONE);
                String result = null;
                try{
                    result = response.getString("date");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void parsingJSONData(String data){
        List<Board> list = new ArrayList<>();
        try{
            JSONArray jsonArray = new JSONArray(data);
            for(int i =0; i<jsonArray.length();i++){
                Board board = new Board();
                JSONObject jObject = jsonArray.getJSONObject(i);
                board.setNno(Integer.parseInt(jObject.getString("nno")));
                board.setContents(jObject.getString("context"));
                board.setTitle(jObject.getString("title"));
                board.setCreateDate(jObject.getString("createDate"));
                list.add(board);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void setProgressBar(int visible){
        progressBar.setVisibility(visible);
    }
}