package Dagger2;

import javax.inject.Singleton;

import dagger.Component;
import presenters.UserDetailsPresenterImp;

/**
 * Created by Mahmoud samy on 7/23/2017.
 */

@Singleton
@Component(modules = {UserDetailsPreesenterImpModule.class})
public interface UserDetailsPresenterImpComponant {

    UserDetailsPresenterImp providesUserDetailsPresenterImp();
}
