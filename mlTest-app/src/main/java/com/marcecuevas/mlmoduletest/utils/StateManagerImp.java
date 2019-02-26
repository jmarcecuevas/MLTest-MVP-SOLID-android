package com.marcecuevas.mlmoduletest.utils;

import android.content.Context;

import com.marcecuevas.mltest_core.util.StateManager;
import com.mirhoseini.utils.Utils;

import javax.inject.Inject;

public class StateManagerImp implements StateManager {

    private Context context;

    @Inject
    public StateManagerImp(Context context) {
        this.context = context;
    }

    @Override
    public boolean isConnect() {
        return Utils.isConnected(context);
    }
}
