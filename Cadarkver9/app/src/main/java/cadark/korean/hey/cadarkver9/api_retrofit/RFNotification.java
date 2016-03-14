package cadark.korean.hey.cadarkver9.api_retrofit;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import cadark.korean.hey.cadarkver9.app.RFApplication;
import cadark.korean.hey.cadarkver9.models.NotificaionListModel;
import retrofit.Call;

/**
 * Created by SonNV1368 on 10/22/15.
 */
public class RFNotification {

    //get contacts
        public static ArrayList<NotificaionListModel> getNotificationList() {
        ArrayList<NotificaionListModel> arrayList = new ArrayList<NotificaionListModel>();
        Call<JsonElement> call = RFApplication.apiServices.getNotifications();

        try {
            JsonElement jsonElement = (JsonElement) call.execute().body();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray jsonArray = jsonObject.getAsJsonArray("notification_user_bid");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject objectContact = jsonArray.get(i).getAsJsonObject();
                String url_image = objectContact.get("url_image").getAsString();
                String name_car = objectContact.get("name_car").getAsString();
                String time_notice = objectContact.get("time_notice").getAsString();

                NotificaionListModel notificationList = new NotificaionListModel(url_image, name_car, time_notice);

                arrayList.add(notificationList);
            }
        } catch (Exception e) {
            Log.e("Error", "Parser: " + e.getMessage().toString());
        }

        return arrayList;
    }
}
