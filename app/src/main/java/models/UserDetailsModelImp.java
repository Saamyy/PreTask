package models;

import android.content.Context;

import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import beans.BaseBeen;
import beans.BaseBeenImp;
import beans.Item;
import beans.RequestUrl;
import presenters.LogInPresenter;
import presenters.UserDetailsPresenter;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public class UserDetailsModelImp implements UserDetailsModel {


    UserDetailsPresenter userDetailsPresenter;
    @Inject
    RequestManager requestManager;
    @Inject
    public UserDetailsModelImp() {

       // this.requestManager=new RequestManagerImp();
    }

    @Override
    public void onFaildFromNetwork(String msg) {
        userDetailsPresenter.onField(msg);

    }

    @Override
    public void getProductsFromNetwork(String token, Context presenterContext,UserDetailsPresenter userDetailsPresenter) {

        this.userDetailsPresenter = userDetailsPresenter;
        Map<String,String> jsonParams = new HashMap<>();
        jsonParams.put("token",token);
        String link="products";
        String uri = String.format(link+"?token=%1$s", token);
        RequestUrl requestUrl=new RequestUrl();
        requestUrl.setPath(uri);
        requestUrl.setParams(jsonParams);
        requestManager.makeHttpRequest(requestUrl,this);

    }

    @Override
    public void onSuccessFromNetWork(BaseBeenImp items) {
        userDetailsPresenter.setItems((Item) items);

    }
}
