package Dagger2;

import com.example.mahmoudsamy.pretask.views.UserDetailsImp;

import javax.inject.Singleton;

import dagger.Component;
import models.UserDetailsModelImp;

/**
 * Created by Mahmoud samy on 7/23/2017.
 */


@Singleton
@Component(modules = {UserDetailsImpModule.class})
public interface UserDetailsImpComponant {
    UserDetailsModelImp povidesUserDetailsImp();

}
