package com.example.mahmoudsamy.pretask.views;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Mahmoud samy on 7/10/2017.
 */

public class ProgressBarCustomImp implements  ProgressBarCustom{

    ProgressBar progressBar;

    public ProgressBarCustomImp(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

}
