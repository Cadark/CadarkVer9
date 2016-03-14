package cadark.korean.hey.cadarkver9;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import cadark.korean.hey.cadarkver9.api_retrofit.RFDetailCar;

/**
 * Created by Hey.Hung on 3/10/2016.
 */
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        ArrayList<String> testArr = RFDetailCar.getDetailCar();

        String curText = null;

        for (int i = 0; i < testArr.size(); i++) {
            curText = testArr.get(i).toString();
        }

        TextView textView = (TextView) findViewById(R.id.link_test_img);

        //textView.setText(curText);
    }
}
