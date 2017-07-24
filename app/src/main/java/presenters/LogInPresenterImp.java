package presenters;

import android.content.Context;
import android.content.SharedPreferences;

import Dagger2.AppModule;
import Dagger2.DaggerAppComponent;
import Dagger2.ModelModule;
import Dagger2.PresenterModule;
import beans.User;
import models.LogInModel;
import models.LogInModelImp;

import com.example.mahmoudsamy.pretask.views.BaseView;
import com.example.mahmoudsamy.pretask.views.GlobaleClass;
import com.example.mahmoudsamy.pretask.views.LogInView;

import javax.inject.Inject;

/**
 * Created by Mahmoud samy on 7/8/2017.
 */

public class LogInPresenterImp implements LogInPresenter {

    LogInView logInView;

    @Inject
    LogInModel logInModel;

    @Inject
    public  LogInPresenterImp ()
    {


    }


    @Override
    public void validateCredentials(String msisdn, String password) {
        logInView.showProgress();
     /*   if (msisdn.isEmpty()|| password.isEmpty())
        {
            logInView.hideProgress();
            logInView.showError("please enter a valid data ");
        }
        else
        {**/
            logInModel.logIn(msisdn,password,this);
       // }

    }

    @Override
    public void onSuccess(User user) {
        logInView.setUser(user);
        logInView.hideProgress();
        logInView.makeFieldsEmpty();
        logInView.navigateToNextView();
        logInView.saveTosharedperfrance();
        logInView.makeFieldsEmpty();
        logInView.killAchtivty();
    }

    @Override
    public void checkPerfrance() {
        SharedPreferences sharedPreferences = GlobaleClass.context.getSharedPreferences("userData", Context.MODE_PRIVATE);
        String userString=sharedPreferences.getString("user",null);
        if (userString!=null)
        {
            User user=User.getUserFronJsone(userString);
            logInView.setUser(user);
            logInView.navigateToNextView();
            logInView.killAchtivty();
        }

    }

    @Override
    public void attach(LogInView baseView) {
        this.logInView=baseView;
    }

    @Override
    public void onField(String msg) {
        logInView.hideKeybourd();
        logInView.hideProgress();
        logInView.showError(msg);

    }
}
