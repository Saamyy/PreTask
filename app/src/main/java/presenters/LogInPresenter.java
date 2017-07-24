package presenters;

import com.example.mahmoudsamy.pretask.views.BaseView;
import com.example.mahmoudsamy.pretask.views.LogInView;

import beans.User;

/**
 * Created by Mahmoud samy on 7/8/2017.
 */

public interface LogInPresenter extends BasePresenter {

    void validateCredentials(String msisdn, String password);
    void onSuccess(User user);
    void checkPerfrance();
    void attach(LogInView baseView);

}
