package com.example.mahmoudsamy.pretask.views;

import android.app.Application;
import android.content.Context;
import android.view.ViewStub;

import Dagger2.AppComponent;
import Dagger2.AppModule;
import Dagger2.DaggerAppComponent;
//import Dagger2.DaggerAppComponent;
//import Dagger2.DaggerAppComponent;

/**
 * Created by Mahmoud samy on 7/10/2017.
 */

public class GlobaleClass extends Application {
    public  static  Context context;
    private AppComponent appComponent;

    public Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.context=this;
        appComponent = initDagger(this);
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(GlobaleClass application) {
     return  null;

    }

}
