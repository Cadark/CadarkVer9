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
import cadark.korean.hey.cadarkver9.models.NotificaionListModel;
import cadark.korean.hey.cadarkver9.others.CircleTransform;


/**
 * Created by SonNV1368 on 10/22/15.
 */
public class RFAdapterNotificationList extends ArrayAdapter<NotificaionListModel> {
    private static final String TAG = "RFAdapterNotificationList";
    private ArrayList<NotificaionListModel> arrayContact;
    private LayoutInflater inflater;

    public RFAdapterNotificationList(Context context, int resource, ArrayList<NotificaionListModel> objects) {
        super(context, resource, objects);
        this.arrayContact = objects;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.notification_item, null);
            holder.nameCar = (TextView) convertView.findViewById(R.id.nameCarNotice);
            holder.imageCar = (ImageView) convertView.findViewById(R.id.avarCarNotice);
            holder.time = (TextView) convertView.findViewById(R.id.timeCarNotice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        NotificaionListModel carListHome = arrayContact.get(position);
        holder.nameCar.setText(carListHome.getNameCar());
        holder.time.setText(carListHome.getTimeNoticeCar());
        Picasso.with(holder.imageCar.getContext()).load(carListHome.getUrlCar()).transform(new CircleTransform()).into(holder.imageCar);
        return convertView;
    }

    public class ViewHolder {
        public ImageView imageCar;
        public TextView nameCar;
        public TextView time;
    }
}

