package com.marcecuevas.mlmoduletest.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.common.ToolbarActivity;
import com.marcecuevas.mlmoduletest.ui.fragment.DuesSelectorFragment;

public class DuesSelectorActivity extends ToolbarActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_dues_selector;
    }

    @Override
    protected int getFragmentLayout() {
        return R.id.fragment;
    }

    @Override
    protected void init() {
        super.init();
        addFragmentWithBackStack(DuesSelectorFragment.class, false);
    }

    @Override
    protected void injectDependencies(MLApplication application) {

    }

    @Override
    protected String title() {
        return getString(R.string.toolbar_dues_amount);
    }
}
