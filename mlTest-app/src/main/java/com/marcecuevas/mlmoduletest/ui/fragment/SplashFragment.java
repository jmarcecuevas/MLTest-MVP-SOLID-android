package com.marcecuevas.mlmoduletest.ui.fragment;

import android.content.Intent;

import com.marcecuevas.mlmoduletest.R;
import com.marcecuevas.mlmoduletest.main.MLApplication;
import com.marcecuevas.mlmoduletest.ui.activity.HomeActivity;
import com.marcecuevas.mlmoduletest.ui.fragment.common.BaseFragment;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class SplashFragment extends BaseFragment {

    private static final long SPLASH_SCREEN_DELAY = 3500;

    @Override
    protected int getLayout() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void injectDependencies(MLApplication application) {

    }

    @Override
    protected void init() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                next();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    private void next() {
        Intent intent = new Intent(getContext(), HomeActivity.class);
        startActivity(intent);
        Objects.requireNonNull(getActivity()).finish();
    }
}

