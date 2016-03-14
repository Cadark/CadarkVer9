package cadark.korean.hey.cadarkver9.api_retrofit;

import com.google.gson.JsonElement;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by SonNV1368 on 10/22/15.
 *
 * Xay dung cac api lam viec voi server
 */
public interface RFApiServices {

    //get list contact
    @GET("/cadark/listcar")
    Call<JsonElement> getContacts();

    //get list contact
    @GET("cadark/notification_bid")
    Call<JsonElement> getNotifications();

    //get detail car
    @GET("cadark/detail_car")
    Call<JsonElement> getDetailCar();
}
