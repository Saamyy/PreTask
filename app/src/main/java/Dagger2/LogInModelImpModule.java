package Dagger2;

import dagger.Module;
import dagger.Provides;
import models.RequestManager;

/**
 * Created by Mahmoud samy on 7/20/2017.
 */
@Module
public class LogInModelImpModule {
    @Provides
    RequestManager providesRequestMangerImp()
    {
        return  DaggerRequesMangerComponant.create().provideRequestManager();
    }
}
