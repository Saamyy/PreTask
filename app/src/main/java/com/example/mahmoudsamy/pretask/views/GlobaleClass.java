package com.example.mahmoudsamy.pretask.views;

import android.app.Application;
import android.content.Context;
import android.view.ViewStub;

/**
 * Created by Mahmoud samy on 7/10/2017.
 */

public class GlobaleClass extends Application {
    public  static  Context context;

    public Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.context=this;
    }
}
