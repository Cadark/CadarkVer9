package cadark.korean.hey.cadarkver9.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cadark.korean.hey.cadarkver9.R;
import cadark.korean.hey.cadarkver9.api_retrofit.RFDetailCar;
import cadark.korean.hey.cadarkver9.ui.DetailCarActivity;

/**
 * Created by Hey.Hung on 3/10/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    private int[] img_resource = {R.drawable.slide_car1, R.drawable.slide_car2, R.drawable.slide_car3, R.drawable.slide_car4, R.drawable.slide_car5, R.drawable.slide_car6};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context context) {
        this.ctx = context;
     }

    @Override
    public int getCount() {
        return img_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.detailCarImg);

        imageView.setImageResource(img_resource[position]);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
