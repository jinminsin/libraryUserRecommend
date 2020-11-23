package com.slave_mk14.libraryuserrecommendation;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
//Help Class for fragment into Application
public class FragmentHelper {
    private Fragment mainFragment;
    private Fragment testFragment;
    private Fragment testResultFragment;
    private Fragment communityFragment;
    private Fragment postFragment;
    private Fragment postContentFragment;
    private Fragment settingFragment;

    public FragmentHelper(){
        mainFragment = new HomeFragment();
        testFragment = new TestFragment();
        communityFragment = new CommunityListFragment();
        settingFragment = new SettingFragment();
    }

    public void initialFragment(AppCompatActivity activity){
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment, mainFragment).commit();
    }

    public void moveFragment(int index, int viewId, AppCompatActivity activity){
        switch(index){
            case 0:
                activity.getSupportFragmentManager().beginTransaction().replace(viewId, mainFragment).commit();
                Log.e("메인메인","프래그먼트 생성했어요");
                break;
            case 1:
                activity.getSupportFragmentManager().beginTransaction().replace(viewId, testFragment).commit();
                Log.e("테스테스","프래그먼트 생성했어요");
                break;
            case 2:
                if(postContentFragment != null && !postContentFragment.isDetached()) activity.getSupportFragmentManager().beginTransaction().replace(viewId, postContentFragment).commit();
                else if(postFragment != null && !postFragment.isDetached()) activity.getSupportFragmentManager().beginTransaction().replace(viewId, postFragment).commit();
                else activity.getSupportFragmentManager().beginTransaction().replace(viewId, communityFragment).commit();
                Log.e("커뮤커뮤","프래그먼트 생성했어요");
                break;
            case 3:
                activity.getSupportFragmentManager().beginTransaction().replace(viewId, settingFragment).commit();
                Log.e("세팅세팅","프래그먼트 생성했어요");
                break;
        }
    }

    public void goTestResultFragment(int viewId, String index, Fragment fragment){
        testResultFragment = new TestResultFragment(index);
        fragment.getFragmentManager().beginTransaction().replace(viewId, testResultFragment).commit();
    }

    public void goPostFragment(int cid, int viewId, Fragment fragment)
    {
        postFragment = new PostListFragment(cid);
        fragment.getFragmentManager().beginTransaction().replace(viewId, postFragment).commit();
    }

    public void goPostContentFragment(Post p, int viewId, Fragment fragment)
    {
        postContentFragment = new PostContentFragment(p);
        fragment.getFragmentManager().beginTransaction().replace(viewId, postContentFragment).commit();
    }

    public void endPostFragment(int viewId, AppCompatActivity activity)
    {
        postFragment.onDestroy();
        activity.getSupportFragmentManager().beginTransaction().replace(viewId, communityFragment).commit();
    }

    public void endPostContentFragment(int viewId, AppCompatActivity activity)
    {
        postContentFragment.onDestroy();
        activity.getSupportFragmentManager().beginTransaction().replace(viewId, postFragment).commit();
    }
}