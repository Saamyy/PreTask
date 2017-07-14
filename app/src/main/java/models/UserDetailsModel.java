package models;

import android.content.Context;

import beans.Item;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public interface UserDetailsModel extends BaseModel {

    public  void getProductsFromNetwork(String token,Context presenterContext);


}
