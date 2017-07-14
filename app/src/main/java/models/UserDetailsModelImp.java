package models;

import android.content.Context;

import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

import beans.BaseBeen;
import beans.BaseBeenImp;
import beans.Item;
import beans.RequestUrl;
import presenters.UserDetailsPresenter;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public class UserDetailsModelImp implements UserDetailsModel {


    UserDetailsPresenter userDetailsPresenter;
    RequestManager requestManager;

    public UserDetailsModelImp(UserDetailsPresenter userDetailsPresenter) {
        this.userDetailsPresenter = userDetailsPresenter;
        this.requestManager=new RequestManagerImp(this);
    }

    @Override
    public void onFaildFromNetwork(String msg) {
        userDetailsPresenter.onField(msg);

    }

    @Override
    public void getProductsFromNetwork(String token, Context presenterContext) {

        Map<String,String> jsonParams = new HashMap<>();
        jsonParams.put("token",token);
        String link="products";
        String uri = String.format(link+"?token=%1$s", token);
        RequestUrl requestUrl=new RequestUrl();
        requestUrl.setPath(uri);
        requestUrl.setParams(jsonParams);
        requestManager.makeHttpRequest(requestUrl);

    }

    @Override
    public void onSuccessFromNetWork(BaseBeen items) {
        userDetailsPresenter.setItems((Item) items);

    }
}
