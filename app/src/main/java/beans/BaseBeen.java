package beans;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;

/**
 * Created by Mahmoud samy on 7/13/2017.
 */

public interface BaseBeen<T> {
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    default <T extends BaseBeen> T getObjectFromJsone(String serverRespond, Class<T> Klass) {
//        T object;
//        Gson gson = new Gson();
//        object = gson.fromJson(serverRespond, Klass);
//        return object;
//    }
}
