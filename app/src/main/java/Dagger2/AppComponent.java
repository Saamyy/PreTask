package Dagger2;

import com.example.mahmoudsamy.pretask.views.ActivityLogin;

import javax.inject.Singleton;

import dagger.Component;
import presenters.LogInPresenter;
import presenters.LogInPresenterImp;

/**
 * Created by Mahmoud samy on 7/19/2017.
 */


@Singleton
@Component(modules = {AppModule.class,PresenterModule.class})
public interface AppComponent {
  LogInPresenterImp provideLogInPresnterImp();

}
