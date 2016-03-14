package cadark.korean.hey.cadarkver9.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

import cadark.korean.hey.cadarkver9.R;
import cadark.korean.hey.cadarkver9.adapter.RFAdapterNotificationList;
import cadark.korean.hey.cadarkver9.api_retrofit.RFNotification;
import cadark.korean.hey.cadarkver9.models.NotificaionListModel;

public class NotificationActivity extends Activity implements AdapterView.OnItemClickListener{

    private ListView listViewNotification;
    private RFAdapterNotificationList adapterNotificationt;
    private ArrayList<NotificaionListModel> arrayList;
    FrameLayout backBtnNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        arrayList = RFNotification.getNotificationList();
        listViewNotification = (ListView) findViewById(R.id.listNotification);
        adapterNotificationt = new RFAdapterNotificationList(this, R.layout.notification_item, arrayList);
        listViewNotification.setAdapter(adapterNotificationt);
        listViewNotification.setOnItemClickListener(this);
    }

    private void initView() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        backBtnNotice = (FrameLayout) findViewById(R.id.backBtnNotice);
        backBtnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this,BidPriceActivity.class));
    }
}
