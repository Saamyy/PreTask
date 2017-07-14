package presenters;

import android.content.Context;

import com.example.mahmoudsamy.pretask.views.UserDetails;

import beans.Item;
import beans.User;
import models.UserDetailsModel;
import models.UserDetailsModelImp;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public class UserDetailsPresenterImp   implements  UserDetailsPresenter{
    UserDetails userDetails;
    UserDetailsModel userDetailsModel;
    Context context;

    public UserDetailsPresenterImp(UserDetails userDetails,Context context) {

        this.userDetails = userDetails;
        userDetailsModel=new UserDetailsModelImp(this);
        this.context=context;
    }

    @Override
    public void onField(String msg) {

        userDetails.hideProgress();
        userDetails.showError(msg);


    }

    @Override
    public void getUser() {
        userDetails.getUserFromIntent();

    }

    @Override
    public void setUi() {
        userDetails.setDataToUi();

    }

    @Override
    public void setItems(Item items) {
        userDetails.setItems(items);
        userDetails.hideProgress();
        userDetails.navigateToNextView();

    }

    @Override
    public void getItems(String token) {
        userDetails.showProgress();
        userDetailsModel.getProductsFromNetwork(token,this.context);

    }


}
