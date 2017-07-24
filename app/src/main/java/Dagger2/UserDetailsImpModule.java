package Dagger2;

import dagger.Module;
import dagger.Provides;
import models.RequestManager;

/**
 * Created by Mahmoud samy on 7/23/2017.
 */

@Module
public class UserDetailsImpModule {

    @Provides
    RequestManager providesRequestMangerImp()
    {
        return  DaggerRequesMangerComponant.create().provideRequestManager();
    }

}
