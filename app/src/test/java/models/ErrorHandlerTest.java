package models;

import com.android.volley.NetworkResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import beans.BaseBeen;

import static org.junit.Assert.*;

/**
 * Created by Mahmoud samy on 7/16/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ErrorHandlerTest {

    @Mock
    BaseModel baseModel;
    @Test
    public void handleError()  {


        BaseModel baseModel = Mockito.mock(BaseModel.class);

        String test=new String("service not available Now");
       // Mockito.doNothing().when(baseModel).onFaildFromNetwork("hi");
     //   Mockito.doCallRealMethod().when(baseModel).onFaildFromNetwork("Hi");
        NetworkResponse response = new NetworkResponse(503,null,null,true);
     //   NetworkResponse response=Mockito.mock(NetworkResponse.class);
       // Mockito.when(response.statusCode).thenReturn(503);
        ErrorHandler errorHandler=new ErrorHandler();
        errorHandler.handleError(response,baseModel);
        assertEquals(test,errorHandler.test);

    }

}