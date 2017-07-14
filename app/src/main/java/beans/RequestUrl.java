package beans;

import java.util.Map;

/**
 * Created by Mahmoud samy on 7/12/2017.
 */

public class RequestUrl {
    String path;
    Map<String,String> params;

    public RequestUrl(String path, Map<String, String> params) {
        this.path = path;
        this.params = params;
    }
    public  RequestUrl()
    {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
