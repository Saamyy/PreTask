package models;

import beans.BaseBeen;
import beans.BaseBeenImp;
import presenters.LogInPresenter;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public interface BaseModel {

    public void onFaildFromNetwork(String msg);
    public  void onSuccessFromNetWork(BaseBeenImp object);
}
