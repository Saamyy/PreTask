package presenters;

import beans.Item;

/**
 * Created by Mahmoud samy on 7/9/2017.
 */

public interface UserDetailsPresenter extends BasePresenter {
    void getUser();
    void setUi();
    void setItems(Item items);
    void getItems(String token);




}
