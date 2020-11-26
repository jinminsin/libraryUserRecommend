package com.slave_mk14.libraryuserrecommendation;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DBResponse {
    static String URL = "http://39.112.64.186/";
    //static String URL = "http://192.168.0.17/";

    static void loginResponse(RequestQueue q, String id, String pw, Response.Listener<String> listener){
        userDBResponse res = new userDBResponse(URL+ "login.php",id,pw,listener);
        q.add(res);
        //Return Json {"success":"1","result":[{"seedid":"1","id":"test","pw":"test","authority":"1","type":"-1"}]}(성공) or
        //Return Json {"success":"-1"}(실패),{"success":"0"}(없음)
    }//로그인

    static void joinResponse(RequestQueue q, String id, String pw, Response.Listener<String> listener){
        userDBResponse res = new userDBResponse(URL+ "join.php",id,pw,listener);
        q.add(res);
        //Return String "0"(중복),"-1"(실패),"1"(성공)
    }//회원가입

    static void saveBookCodeResponse(RequestQueue q, int seedid,String likeBookCode,String siblingLikeBookCode,Response.Listener<String> listener){
        userDBResponse res = new userDBResponse(URL+ "saveLikeBookCode.php",seedid, likeBookCode, siblingLikeBookCode, listener);
        q.add(res);
        //Return String "-1"(실패),"1"(성공)
    }

    static void resetBookCodeResponse(RequestQueue q, int seedid, Response.Listener<String> listener){
        userDBResponse res = new userDBResponse(URL+ "saveLikeBookCode.php",seedid, "-1", "-1", listener);
        q.add(res);
        //Return String "-1"(실패),"1"(성공)
    }

    static void searchRecommendBookListResponse(RequestQueue q, String bookCode,Response.Listener<String> listener){
        bookDBResponse res = new bookDBResponse(URL+ "book.php",bookCode, listener);
        q.add(res);
    }

    static void searchCommunityResponse(RequestQueue q, Response.Listener<String> listener){
        communityDBResponse res = new communityDBResponse(URL+ "community.php",listener);
        q.add(res);
        //Return Json : {"result":[{"id":"1","name":"테스트 커뮤니티","detail":"테스트 중입니다.","owner":"운영자","createDate":"2020-11-09 13:28"}]}
    }//커뮤니티 리스트

    static void searchPostResponse(RequestQueue q, int cid, Response.Listener<String> listener){
        postDBResponse res = new postDBResponse(URL+ "post.php",cid,listener);
        q.add(res);
        //Return Json : {{"result":[{"cid":"1","id":"1","title":"테스트 게시물","subtitle":"테스트 시행 중입니다.","owner":"운영자","createDate":"2020-11-09 13:42","password":"xxxx"}]}
    }//게시물 리스트

    static void addPostResponse(RequestQueue q, Post p, Response.Listener<String> listener){
        postDBResponse res = new postDBResponse(URL+ "createPost.php", p, listener);
        q.add(res);
        //Return String "-1","1"
    }//게시물 작성

    static void searchCommentResponse(RequestQueue q, int pid, Response.Listener<String> listener){
        commentDBResponse res = new commentDBResponse(URL+ "comment.php",pid,listener);
        q.add(res);
        //Return Json : {"result":[{"pid":"1","id":"1","subtitle":"테스트 댓글 시행 중입니다.","owner":"운영자","createDate":"2020-11-09 13:44","password":"yyyy"}]}
    }//댓글 리스트

    static void addCommentResponse(RequestQueue q, Comment c, Response.Listener<String> listener){
        commentDBResponse res = new commentDBResponse(URL+ "createComment.php",c,listener);
        q.add(res);
        //Return String "-1","1"
    }//댓글 작성

    static class bookDBResponse extends StringRequest {
        private Map<String, String> map;

        public bookDBResponse(String url, String bookcode, Response.Listener<String> listener) {
            super(Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("bookcode", bookcode);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return map;
        }
    }

    static class userDBResponse extends StringRequest {
        private Map<String, String> map;

        public userDBResponse(String url, String id, String pw, Response.Listener<String> listener) {
            super(Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("id", id);
            map.put("pw", pw);
        }

        public userDBResponse(String url, int seedid,String likeBookCode,String siblingLikeBookCode, Response.Listener<String> listener) {
            super(Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("seedid", ""+seedid);
            map.put("likebookcode",likeBookCode);
            map.put("siblinglikebookcode", siblingLikeBookCode);
        }

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return map;
        }
    }

    static class communityDBResponse extends StringRequest {
        private Map<String, String> map;

        public communityDBResponse(String url, Response.Listener<String> listener) {
            super(Method.POST, url, listener, null);
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
            super(Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("cid", ""+cid);
        }

        public postDBResponse(String url, Post p, Response.Listener<String> listener) {
            super(Method.POST, url, listener, null);
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
            super(Method.POST, url, listener, null);
            map = new HashMap<>();
            map.put("pid", ""+pid);
        }

        public commentDBResponse(String url, Comment c, Response.Listener<String> listener) {
            super(Method.POST, url, listener, null);
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