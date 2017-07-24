package models;

import com.android.volley.NetworkResponse;

import beans.ErrorMsgs;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public class ErrorHandler implements  ErrorLayer {

        String test=new String();

    @Override
    public  void handleError(NetworkResponse response,BaseModel model) {

        switch(response.statusCode){
            case 401:
              String  json = new String(response.data);
                String msg=ErrorMsgs.getErrorFromJson(json);
                model.onFaildFromNetwork(msg);
                test=msg;
                break;
            case 503:
                model.onFaildFromNetwork("service not available Now");
                test="service not available Now";
                break;
        }

    }
}
