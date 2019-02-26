package com.marcecuevas.mlmoduletest.ui.activity;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.common.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void init() {

    }

    @Override
    protected int getFragmentLayout() {
        return R.id.fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void injectDependencies(MLApplication application) {

    }
}
