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
    static String URL = "http://192.168.123.105:80/";

    static void loginResponse(RequestQueue q, String id, String pw, Response.Listener<String> listener){
        userDBResponse res = new userDBResponse(URL+ "login.php",id,pw,listener);
        q.add(res);
    }

    static void joinResponse(RequestQueue q, String id, String pw, Response.Listener<String> listener){
        userDBResponse res = new userDBResponse(URL+ "join.php",id,pw,listener);
        q.add(res);
    }

    static void searchCommunityResponse(RequestQueue q, Response.Listener<String> listener){
        communityDBResponse res = new communityDBResponse(URL+ "community.php",listener);
        q.add(res);
    }

    static void searchPostResponse(RequestQueue q, int cid, Response.Listener<String> listener){
        postDBResponse res = new postDBResponse(URL+ "post.php",cid,listener);
        q.add(res);
    }

    static void addPostResponse(RequestQueue q, Post p, Response.Listener<String> listener){
        postDBResponse res = new postDBResponse(URL+ "createPost.php", p, listener);
        q.add(res);
    }

    static void searchCommentResponse(RequestQueue q, int pid, Response.Listener<String> listener){
        commentDBResponse res = new commentDBResponse(URL+ "comment.php",pid,listener);
        q.add(res);
    }

    static void addCommentResponse(RequestQueue q, Comment c, Response.Listener<String> listener){
        commentDBResponse res = new commentDBResponse(URL+ "createComment.php",c,listener);
        q.add(res);
    }

    static class userDBResponse extends StringRequest {
        private Map<String, String> map;

        public userDBResponse(String url, String id, String pw, Response.Listener<String> listener) {
            super(Request.Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("id", id);
            map.put("pw", pw);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return map;
        }
    }

    static class communityDBResponse extends StringRequest {
        private Map<String, String> map;

        public communityDBResponse(String url, Response.Listener<String> listener) {
            super(Request.Method.POST, url, listener, null);
            map = new HashMap<>();
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return map;
        }
    }

    static class postDBResponse extends StringRequest {
        private Map<String, String> map;

        public postDBResponse(String url, int cid, Response.Listener<String> listener) {
            super(Request.Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("cid", ""+cid);
        }

        public postDBResponse(String url, Post p, Response.Listener<String> listener) {
            super(Request.Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("cid", ""+p.getCid());
            map.put("title",p.getTitle());
            map.put("subtitle",p.getSubtitle());
            map.put("owner",p.getOwner());
            map.put("createDate",p.getCreateDate());
            map.put("password",p.getPassword());
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return map;
        }
    }

    static class commentDBResponse extends StringRequest {
        private Map<String, String> map;

        public commentDBResponse(String url, int pid, Response.Listener<String> listener) {
            super(Request.Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("pid", ""+pid);
        }

        public commentDBResponse(String url, Comment c, Response.Listener<String> listener) {
            super(Request.Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("pid", ""+c.getPid());
            map.put("subtitle",c.getSubtitle());
            map.put("owner",c.getOwner());
            map.put("createDate",c.getCreateDate());
            map.put("password",c.getPassword());
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return map;
        }
    }
}