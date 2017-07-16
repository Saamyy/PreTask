package beans;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public class Item extends BaseBeenImp implements Serializable,BaseBeen {
    List<Products> items;

    public Item() {
    }

    public Item(List<Products> items) {
        System.out.println("Hi ");
        this.items = items;
        System.out.println("uhugas");
    }

    public List<Products> getItems() {
        return items;
    }

    public void setItems(List<Products> items) {


        System.out.println("HI");
        this.items = items;
    }

    public static Item getItemsFromJsone(String serverRespond)
    {
        Item item=new Item();
        Gson gson= new Gson();
        item=gson.fromJson(serverRespond,Item.class);
        return  item;
    }
}
