package cadark.korean.hey.cadarkver9.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.viewpagerindicator.CirclePageIndicator;

import cadark.korean.hey.cadarkver9.R;
import cadark.korean.hey.cadarkver9.adapter.CustomSwipeAdapter;


/**
 * Created by Hey.Hung on 3/4/2016.
 */
public class BidPriceActivity extends Activity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private LinearLayout llProfileBid;
    FrameLayout backBtnNotice;

    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    ViewGroup contentHideShow;
    Button buttonShowHide;
    public static boolean isShow = true;

    private CirclePageIndicator circlePageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_car);
        llProfileBid = (LinearLayout) findViewById(R.id.ll_item_bid);
        backBtnNotice = (FrameLayout) findViewById(R.id.backBtnNotice);
        backBtnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        llProfileBid.setOnClickListener(this);

        viewPager = (ViewPager) findViewById(R.id.view_pager2);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);

        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.cicle2);
        circlePageIndicator.setViewPager(viewPager);

        contentHideShow = (ViewGroup) findViewById(R.id.contentHideShow);
        buttonShowHide = (Button) findViewById(R.id.buttonShowHide);
        buttonShowHide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_item_bid:
                startActivity(new Intent(this,UserProfileBidActivity.class));
                break;

            case R.id.buttonShowHide:
                isShow = !isShow;
                if (isShow) {
                    Animation bottomDown = AnimationUtils.loadAnimation(this, R.anim.bottom_down);

                    contentHideShow.setAnimation(bottomDown);
                    contentHideShow.setVisibility(LinearLayout.VISIBLE);
                    buttonShowHide.setText("HIDE DETAIL");
                }
                else {
                    contentHideShow.setVisibility(LinearLayout.GONE);
                    buttonShowHide.setText("SHOW DETAIL");
                }
                break;
        }
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
