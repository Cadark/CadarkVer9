package cadark.korean.hey.cadarkver9.app;

import android.app.Application;

import cadark.korean.hey.cadarkver9.api_retrofit.RFApiCommon;
import cadark.korean.hey.cadarkver9.api_retrofit.RFApiServices;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by SonNV1368 on 10/22/15.
 * Xay dung nhung thanh phan chi khoi tao 1 lan
 *
 */
public class RFApplication extends Application {
    public static Retrofit mRetrofit;
    public static RFApiServices apiServices;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(RFApiCommon.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiServices = mRetrofit.create(RFApiServices.class);
    }

}
