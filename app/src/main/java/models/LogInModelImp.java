package models;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import beans.BaseBeen;
import beans.BaseBeenImp;
import beans.RequestUrl;
import beans.User;
import presenters.LogInPresenter;

/**
 * Created by Mahmoud samy on 7/8/2017.
 */

public class LogInModelImp  implements LogInModel{
    LogInPresenter logInPresenter;
    @Inject
    RequestManager requestManager;
    @Inject
    public  LogInModelImp()
    {

    }

    @Override
    public void logIn(String msisdn, String password,LogInPresenter logInPresenter) {
        this.logInPresenter=logInPresenter;
        Map<String,String> jsonParams = new HashMap<>();
        jsonParams.put("msisdn",msisdn);
        jsonParams.put("password",password);

        String link="authenticate";
        String uri = String.format(link+"?msisdn=%1$s&password=%2$s",
                jsonParams.get("msisdn"),
                jsonParams.get("password"));
        String finalUrl=new String();
        if (jsonParams.get("msisdn").isEmpty()&&jsonParams.get("password").isEmpty())
        {
            finalUrl=link;

        }
        else
        {
            finalUrl=uri;
        }
        RequestUrl request=new RequestUrl();
        request.setPath(finalUrl);
        System.out.println(requestManager);
        requestManager.makeHttpRequest(request,this);
    }

    @Override
    public void onSuccessFromNetWork(BaseBeenImp user) {
        logInPresenter.onSuccess((User) user);
    }

    @Override
    public void onFaildFromNetwork(String msg) {
        logInPresenter.onField(msg);


    }

}
