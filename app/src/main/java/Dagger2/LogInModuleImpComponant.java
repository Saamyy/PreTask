package Dagger2;

import javax.inject.Singleton;

import dagger.Component;
import models.LogInModelImp;

/**
 * Created by Mahmoud samy on 7/20/2017.
 */
@Singleton
@Component(modules = {LogInModelImpModule.class})
public interface LogInModuleImpComponant {

    LogInModelImp provideLogInModelImp();
}
