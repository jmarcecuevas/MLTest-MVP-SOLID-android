package com.marcecuevas.mlmoduletest.ui.activity;

import android.content.Context;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.common.BaseActivity;
import com.marcecuevas.mlmoduletest.ui.fragment.MainFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    protected Context context;

    @Override
    protected void init() {
        addFragmentWithBackStack(MainFragment.class,false);
    }

    protected int getFragmentLayout() {
        return R.id.fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void injectDependencies(MLApplication application) {
        application.createComponent().inject(this);
    }
}
