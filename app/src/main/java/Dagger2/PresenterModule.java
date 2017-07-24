package Dagger2;

import com.example.mahmoudsamy.pretask.views.ActivityLogin;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import models.LogInModel;
import models.LogInModelImp;
import presenters.LogInPresenter;
import presenters.LogInPresenterImp;

/**
 * Created by Mahmoud samy on 7/19/2017.
 */
@Module
public class PresenterModule {
//    ActivityLogin login;
//    LogInPresenterImp logInPresenter;
//
//
//    public PresenterModule(ActivityLogin login) {
//        this.login = login;
//    }
//
//    @Provides
//    @Singleton
//    LogInPresenter provideLoginPresenetrImp()
//    {
//        logInPresenter= new LogInPresenterImp(login);
//        return  new LogInPresenterImp(login);
//
//    }
//
//    @Provides
//    LogInModel provideLogInModelImp()
//    {
//        return  new LogInModelImp(logInPresenter);
//    }

    @Provides
    @Singleton
    LogInModel provideLoginModel(){
        return DaggerLogInModuleImpComponant.create().provideLogInModelImp();
    }

}
