package com.example.mahmoudsamy.pretask.views;

import android.view.View;

import beans.User;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public interface BaseView {
    void navigateToNextView();

    void setUser(User user);

    void showError(String errorMsg);

    void showProgress();


    void hideProgress();



}
