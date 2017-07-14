package models;

import com.android.volley.NetworkResponse;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public interface ErrorLayer {
     void handleError(NetworkResponse response,BaseModel model);
}
