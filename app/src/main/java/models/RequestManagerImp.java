package models;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mahmoudsamy.pretask.views.GlobaleClass;

import org.json.JSONException;
import org.json.JSONObject;

import beans.BaseBeen;
import beans.Item;
import beans.RequestUrl;
import beans.User;

/**
 * Created by Mahmoud samy on 7/8/2017.
 */

public class RequestManagerImp implements RequestManager {


    private static final String url = "http://mvp-poc.getsandbox.com/";
    ErrorLayer errorLayer;
    BaseModel model;




    public  RequestManagerImp(BaseModel logInModel)
    {
        this.model=logInModel;
        this.errorLayer=new ErrorHandler();

    }



    @Override
    public void makeHttpRequest(RequestUrl request) {


        RequestQueue queue = Volley.newRequestQueue(GlobaleClass.context);
        StringRequest sr = new StringRequest(Request.Method.GET, url+request.getPath(),
                new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(String response) {
                        Log.e("HttpClient", "success! response: " + response.toString());
                        try {
                            JSONObject jsonObject=new JSONObject(response.toString());

                            if (jsonObject.has("userType")) {
                                BaseBeen<User> networkUser = new User();
                                networkUser = new User().getObjectFromJsone(response.toString(),User.class);
                                model.onSuccessFromNetWork((User)networkUser);
                            }
                            else if(jsonObject.has("items"))
                            {
                                BaseBeen<Item> items=new Item();
                                items=new Item().getObjectFromJsone(response.toString(),Item.class);
                                model.onSuccessFromNetWork(items);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        NetworkResponse response = error.networkResponse;


                        if(response != null && response.data != null)
                        {
                            errorLayer.handleError(response,model);
                        }

                        Log.e("HttpClient", "error: " + error.toString());
                    }
                });

        queue.add(sr);
    }
}
