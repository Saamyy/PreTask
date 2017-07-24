package com.example.mahmoudsamy.pretask.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mahmoudsamy.pretask.R;
import com.google.gson.Gson;

import javax.inject.Inject;

import Dagger2.AppModule;
import Dagger2.DaggerAppComponent;
import Dagger2.PresenterModule;
import beans.User;
import presenters.LogInPresenter;
import presenters.LogInPresenterImp;

public class ActivityLogin extends AppCompatActivity  implements LogInView{

    EditText msisdn;
    EditText passWord;
    Button logIn;
    @Inject
    LogInPresenter logInPresenter;

    ProgressBar progressBar;
    User user;
    ProgressBarCustom progressBarCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ((GlobaleClass)getApplication()).getAppComponent().inject(this);
//        DaggerAppComponent.builder()
//                .appModule(new AppModule(getApplication()))
//                .presenterModule(new PresenterModule(this))
//                .build().inject(this);

       logInPresenter=DaggerAppComponent.create().provideLogInPresnterImp();
        logInPresenter.attach(this);
        setContentView(R.layout.activity_login);
        logInPresenter.checkPerfrance();
        msisdn=(EditText) findViewById(R.id.msisdnEditText);
        passWord=(EditText) findViewById(R.id.passwordEditText);
        logIn=(Button) findViewById(R.id.loginButton);
        progressBar = (ProgressBar) findViewById(R.id.progress);
       progressBarCustom=new ProgressBarCustomImp(this.progressBar);

        user=new User();
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInPresenter.validateCredentials(msisdn.getText().toString(),passWord.getText().toString());
            }
        });

    }



    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void makeFieldsEmpty() {
        msisdn.setText("");
        passWord.setText("");
    }
    @Override
    public void hideKeybourd(){
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(passWord.getWindowToken(), 0);
    }

    @Override
    public void navigateToNextView() {
        Intent goToUserDetails=new Intent(this,UserDetailsImp.class);
        goToUserDetails.putExtra("user",this.user);
        startActivity(goToUserDetails);
    }

    @Override
    public void setUser(User user) {
        this.user=user;
    }


    @Override
    public void saveTosharedperfrance() {
        SharedPreferences preferences = getSharedPreferences("userData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(this.user);
        editor.putString("user" , json);
        editor.commit();
    }

    @Override
    public void killAchtivty() {

       this.finish();
        return;
    }

}
