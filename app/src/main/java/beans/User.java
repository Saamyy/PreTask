package beans;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Created by Mahmoud samy on 7/8/2017.
 */

public class User extends BaseBeenImp implements Serializable,BaseBeen {
   private int version;
    private String givenName;
    private String surName;
    private  String userType;
    private String token;

    public User(int version, String givenName, String surName, String userType, String token) {
        this.version = version;
        this.givenName = givenName;
        this.surName = surName;
        this.userType = userType;
        this.token = token;
    }

    public User() {

    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public  static User getUserFronJsone(String serverRespond)
    {
        User user=new User();
        Gson gson= new Gson();
        user=gson.fromJson(serverRespond,User.class);
        return  user;
    }

}
