package cadark.korean.hey.cadarkver9.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cadark.korean.hey.cadarkver9.R;
import cadark.korean.hey.cadarkver9.models.CarListHomeModel;


/**
 * Created by SonNV1368 on 10/22/15.
 */
public class RFAdapterListCarHome extends ArrayAdapter<CarListHomeModel> {
    private static final String TAG = "RFAdapterListCarHome";
    private ArrayList<CarListHomeModel> arrayContact;
    private LayoutInflater inflater;

    public RFAdapterListCarHome(Context context, int resource, ArrayList<CarListHomeModel> objects) {
        super(context, resource, objects);
        this.arrayContact = objects;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list_car, null);
            holder.nameCar = (TextView) convertView.findViewById(R.id.tv_name_car);
            holder.imageCar = (ImageView) convertView.findViewById(R.id.iv_image_car);
            holder.timeRemain = (TextView) convertView.findViewById(R.id.tv_time);
            holder.years = (TextView) convertView.findViewById(R.id.tv_year);
            holder.mileage = (TextView) convertView.findViewById(R.id.tv_mileage);
            holder.area = (TextView) convertView.findViewById(R.id.tv_area);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CarListHomeModel carListHome = arrayContact.get(position);
        holder.nameCar.setText(carListHome.getNameCar());
        holder.timeRemain.setText("" + chageTime(Integer.parseInt(carListHome.getTimeRemain())));
        holder.years.setText(carListHome.getYears());
        holder.mileage.setText(carListHome.getMileage()+" km");
        holder.area.setText(carListHome.getArea());
        Picasso.with(holder.imageCar.getContext()).load(carListHome.getUrlCar()).into(holder.imageCar);
        return convertView;
    }
    public String chageTime(int minute){
        int d = minute/1440;
        int h = Math.abs(minute - 1440)/60;
        if(h==24){
            h=0;
        }
        int m =Math.abs(minute - 1440)%60;
        return ""+d+"d "+h+"h "+m+"m";
    }
    public class ViewHolder {
        public int idCar;
        public TextView nameCar;
        public TextView timeRemain;
        public TextView years;
        public TextView mileage;
        public TextView area;
        public ImageView imageCar;

    }
}
