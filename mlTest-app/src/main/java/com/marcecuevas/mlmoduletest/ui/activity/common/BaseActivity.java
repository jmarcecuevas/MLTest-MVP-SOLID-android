package com.marcecuevas.mlmoduletest.ui.activity.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        injectDependencies(MLApplication.get(this));
        ButterKnife.bind(this);
        init();
    }

    protected abstract void init();

    protected abstract int getFragmentLayout();

    protected abstract int getLayout();

    protected abstract void injectDependencies(MLApplication application);

    @Override
    public void startActivity(Intent intent){
        super.startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overrideBackAnimation();
    }

    protected void overrideBackAnimation(){
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }

    public Fragment addFragmentWithBackStack(Class myNewFragmentClass, Boolean withBackstack) {
        Fragment myNewFragment = Fragment.instantiate(getApplicationContext(), myNewFragmentClass.getName());
        String newFragment = myNewFragment.getClass().getName();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        if (withBackstack){
            t.setCustomAnimations(R.anim.pull_in_right,R.anim.push_out_left,R.anim.pull_in_left, R.anim.push_out_right);
            t.addToBackStack(newFragment);
        }
        t.add(getFragmentLayout(), myNewFragment, newFragment);
        t.commit();
        return myNewFragment;
    }

    public Fragment replaceFragmentWithBackStack(Class myNewFragmentClass, Boolean withBackstack) {
        return this.replaceFragmentWithBackStack(myNewFragmentClass, withBackstack, null);
    }

    public Fragment replaceFragmentWithBackStack(Class myNewFragmentClass, Boolean withBackstack, Bundle bundle) {
        Fragment myNewFragment = Fragment.instantiate(getApplicationContext(), myNewFragmentClass.getName());
        String newFragment = myNewFragment.getClass().getName();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        myNewFragment.setArguments(bundle);
        if (withBackstack){
            t.setCustomAnimations(R.anim.pull_in_right,R.anim.push_out_left,R.anim.pull_in_left, R.anim.push_out_right);
            t.addToBackStack(newFragment);
        }
        t.replace(getFragmentLayout(), myNewFragment, newFragment);
        t.commit();
        return myNewFragment;
    }

    public Fragment replaceFragmentWithBackStack(Fragment myNewFragment, Boolean withBackstack, Bundle bundle) {
        String newFragment = myNewFragment.getClass().getName();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        if (bundle != null){
            myNewFragment.setArguments(bundle);
        }
        if (withBackstack){
            t.setCustomAnimations(R.anim.pull_in_right,R.anim.push_out_left,R.anim.pull_in_left, R.anim.push_out_right);
            t.addToBackStack(newFragment);
        }
        t.replace(getFragmentLayout(), myNewFragment, newFragment);
        t.commit();
        return myNewFragment;
    }

    public Fragment replaceFragmentWithBackStackAnimate(Fragment myNewFragment, Boolean withBackstack, Bundle bundle) {
        String newFragment = myNewFragment.getClass().getName();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        myNewFragment.setArguments(bundle);
        t.setCustomAnimations(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in, R.anim.fade_out);
        if (withBackstack){
            t.addToBackStack(newFragment);
        }
        t.replace(getFragmentLayout(), myNewFragment, newFragment);
        t.commit();
        return myNewFragment;
    }

    public Fragment replaceFragmentWithBackStackAnimation(Class myNewFragmentClass, Boolean withBackstack) {
        Fragment myNewFragment = Fragment.instantiate(getApplicationContext(), myNewFragmentClass.getName());
        String newFragment = myNewFragment.getClass().getName();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.setCustomAnimations(R.anim.fade_in,R.anim.fade_out,R.anim.fade_in, R.anim.fade_out);
//        t.setCustomAnimations(R.anim.pull_in_right,R.anim.push_out_left,R.anim.pull_in_left, R.anim.push_out_right);
        if (withBackstack){
            t.addToBackStack(newFragment);
        }
        t.replace(getFragmentLayout(), myNewFragment, newFragment);
        t.commit();
        return myNewFragment;
    }
}
