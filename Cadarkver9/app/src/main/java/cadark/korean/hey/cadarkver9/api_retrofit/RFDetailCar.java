package cadark.korean.hey.cadarkver9.api_retrofit;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import cadark.korean.hey.cadarkver9.app.RFApplication;
import cadark.korean.hey.cadarkver9.models.DetailCarModel;
import retrofit.Call;

/**
 * Created by Hey.Hung on 3/10/2016.
 */
public class RFDetailCar {
    //get detail car
    public static ArrayList<String> getDetailCar() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Call<JsonElement> call = RFApplication.apiServices.getDetailCar();

        try {
            JsonElement jsonElement = (JsonElement) call.execute().body();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray jsonArray = jsonObject.getAsJsonArray("url_image_arr");
            for (int i = 0; i < jsonArray.size(); i++) {

                arrayList.add(jsonArray.get(i).toString());
                Log.d("LINK_IMG", jsonArray.get(i).toString());
            }
        } catch (Exception e) {
            Log.e("Error", "Parser: " + e.getMessage().toString());
        }

        return arrayList;
    }
}
