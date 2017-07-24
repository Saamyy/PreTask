package Dagger2;

import dagger.Module;
import dagger.Provides;
import models.ErrorHandler;
import models.ErrorLayer;

/**
 * Created by Mahmoud samy on 7/20/2017.
 */
@Module
public class ErrorHandlerModule {
    @Provides
    ErrorLayer providesErrorHandlerImp()
    {
        return  new ErrorHandler();
    }
}
