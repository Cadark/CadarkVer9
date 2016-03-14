package cadark.korean.hey.cadarkver9.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import cadark.korean.hey.cadarkver9.R;


/**
 * Created by Hey.Hung on 2/25/2016.
 */
public class UserProfileBidActivity extends Activity implements View.OnClickListener {
    private FrameLayout flBack;

    TextView textView16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();

        textView16 = (TextView) findViewById(R.id.textView16);
        textView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog settingsDialog = new Dialog(UserProfileBidActivity.this);
                settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.dialog_id_card, null));
                settingsDialog.show();
            }
        });
    }

    private void initView() {
        flBack = (FrameLayout) findViewById(R.id.fl_back);
        flBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_back:
                finish();
                break;
        }
    }
}
