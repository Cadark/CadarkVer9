package cadark.korean.hey.cadarkver9.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import cadark.korean.hey.cadarkver9.R;
import cadark.korean.hey.cadarkver9.adapter.CustomSwipeAdapter;

/**
 * Created by Hey.Hung on 3/4/2016.
 */
public class DetailCarActivity extends Activity implements ViewPager.OnPageChangeListener {

    FrameLayout backBtnNotice;

    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    private CirclePageIndicator circlePageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_car);

        backBtnNotice = (FrameLayout) findViewById(R.id.backBtnNotice);
        backBtnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);

        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.cicle);
        circlePageIndicator.setViewPager(viewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
