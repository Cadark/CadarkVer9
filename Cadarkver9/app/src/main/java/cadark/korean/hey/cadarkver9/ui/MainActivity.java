package cadark.korean.hey.cadarkver9.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import cadark.korean.hey.cadarkver9.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_upload,
            R.drawable.ic_car,
            R.drawable.ic_guide
    };

    private android.support.v7.widget.Toolbar toolbar;

    private String[] nameTab = {
           "TAB ONE", "TAB TWO", "TAB THREE", "TAB FOUR"
    };

    private FrameLayout fl_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();

                if (menuItem.getItemId() == R.id.nav_item_contact_by_phone) {

                }

                if (menuItem.getItemId() == R.id.nav_item_contact_by_kakao) {

                }

                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        //android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

        fl_notification = (FrameLayout) findViewById(R.id.fl_notification);
        fl_notification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_notification:
                Intent i = new Intent(this, NotificationActivity.class);
                startActivity(i);
                break;
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //Log.i(TAG, "" + position);
            return mFragmentTitleList.get(position);
            // return null;
        }
    }

    private void setupTabIcons() {
        //Tab Home
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        //Tab Upload
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        //Tab Selling
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        //Tab Guide
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);

    }

    private void setupViewPager(ViewPager viewPager) {
        adapter.addFrag(new HomeListcarFragment(), "Home");
        adapter.addFrag(new PostCarFragment(), "Upload");
        adapter.addFrag(new SellingCarFragment(), "Selling");
        adapter.addFrag(new GuideFragment(), "Guide");
        viewPager.setAdapter(adapter);
    }
}
