package beans;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by Mahmoud samy on 7/8/2017.
 */

public class Products extends BaseBeenImp implements Serializable,BaseBeen {

    private   String url;
    private String icon;
    private  String label;
    private String subtitle;

    public Products(String url, String icon, String label, String subtitle) {
        this.url = url;
        this.icon = icon;
        this.label = label;
        this.subtitle = subtitle;
    }
    public  Products()
    {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public static Products getProductFronJsone(String serverRespond)
    {
        Products product=new Products();
        Gson gson= new Gson();
        product=gson.fromJson(serverRespond,Products.class);
        return  product;
    }



}
