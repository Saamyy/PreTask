package Dagger2;

import javax.inject.Singleton;

import dagger.Component;
import models.ErrorHandler;
import models.RequestManager;
import models.RequestManagerImp;

/**
 * Created by Mahmoud samy on 7/20/2017.
 */

@Singleton
@Component(modules = {ErrorHandlerModule.class})
public interface RequesMangerComponant {
    RequestManagerImp provideRequestManager();
}
