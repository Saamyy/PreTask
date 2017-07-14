package com.example.mahmoudsamy.pretask.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoudsamy.pretask.R;

import java.io.Serializable;

import beans.Item;
import beans.User;
import presenters.UserDetailsPresenter;
import presenters.UserDetailsPresenterImp;

public class UserDetailsImp extends AppCompatActivity implements UserDetails {
    TextView userName;
    TextView userType;
    Button products;
    User user;
    UserDetailsPresenter userDetailsPresenter;
    ProgressBar progressBar;
    Item items;
    ProgressBarCustom progressBarCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDetailsPresenter =new UserDetailsPresenterImp(this,this.getApplicationContext());
        setContentView(R.layout.activity_user_details);
        user=new User();
        items=new Item();
        userDetailsPresenter.getUser();
        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBarCustom=new ProgressBarCustomImp(this.progressBar);
        userName=(TextView) findViewById(R.id.userName);
        userType=(TextView) findViewById(R.id.userType);
        products=(Button) findViewById(R.id.productsButton);
        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDetailsPresenter.getItems(user.getToken());
            }
        });
        userDetailsPresenter.setUi();

    }

    @Override
    public void navigateToNextView() {

        Intent goToProductsList=new Intent(this,ProductsList.class);

        goToProductsList.putExtra("products",  this.items);
        goToProductsList.putExtra("userType",this.user.getUserType());
        startActivity(goToProductsList);

    }

    @Override
    public void setUser(User user) {
        this.user=user;


    }
    @Override public void showProgress() {
        //progressBarCustom.showProgress();
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(String errorMsg) {
     //   progressBar.setVisibility(View.VISIBLE);
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();

    }

     public void hideProgress() {
         progressBar.setVisibility(View.GONE);

    }
    @Override
    public void getUserFromIntent() {
        Intent i= getIntent();
        User intentUser= (User) i.getSerializableExtra("user");
        this.user=intentUser;
        System.out.println("==========================+++++++++++++++++++++++++++"+user.getSurName());

    }

    @Override
    public void setDataToUi() {

        userName.setText(this.user.getGivenName()+" "+this.user.getSurName());
        userType.setText(this.user.getUserType());

    }

    @Override
    public void setItems(Item items) {
        this.items=items;
    }


}
