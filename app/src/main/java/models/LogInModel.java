package models;

import presenters.LogInPresenter;

/**
 * Created by Mahmoud samy on 7/8/2017.
 */

public interface LogInModel extends BaseModel{
    public  void logIn(String msisdn, String password, LogInPresenter logInPresenter);



}
