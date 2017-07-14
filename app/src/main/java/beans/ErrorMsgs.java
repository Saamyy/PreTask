package beans;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public class ErrorMsgs implements Serializable {
    String errorText;

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
   public static  String getErrorFromJson(String serverRespond)
    {
        ErrorMsgs errorMsgs=new ErrorMsgs();
        Gson gson= new Gson();
        errorMsgs=gson.fromJson(serverRespond,ErrorMsgs.class);
        return  errorMsgs.getErrorText();
    }
}
