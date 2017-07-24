package Dagger2;

import dagger.Module;
import dagger.Provides;
import models.UserDetailsModel;

/**
 * Created by Mahmoud samy on 7/23/2017.
 */

@Module
public class UserDetailsPreesenterImpModule {
    @Provides
    UserDetailsModel providesUserDetailsModelImp()
    {
      return   DaggerUserDetailsImpComponant.create().povidesUserDetailsImp();
    }
}
