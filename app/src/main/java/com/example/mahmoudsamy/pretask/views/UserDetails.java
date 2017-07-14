package com.example.mahmoudsamy.pretask.views;

import beans.Item;
import beans.User;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public interface UserDetails extends BaseView {

    public void getUserFromIntent();
    public void setDataToUi();
    public  void  setItems(Item items);

}
