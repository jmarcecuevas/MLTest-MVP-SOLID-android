package com.marcecuevas.mlmoduletest.ui.activity;

import android.view.View;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.common.ToolbarActivity;
import com.marcecuevas.mlmoduletest.ui.fragment.HomeFragment;

public class HomeActivity extends ToolbarActivity {

    @Override
    protected void init() {
        super.init();
        setBackButtonVisibility(View.GONE);
        addFragmentWithBackStack(HomeFragment.class,false);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentLayout() {
        return R.id.fragment;
    }

    @Override
    protected void injectDependencies(MLApplication application) {
        application.createComponent().inject(this);
    }

    @Override
    protected String title() {
        return getString(R.string.toolbar_how_much);
    }
}
