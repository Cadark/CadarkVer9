package cadark.korean.hey.cadarkver9.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cadark.korean.hey.cadarkver9.R;


/**
 * Created by Hey.Hung on 3/4/2016.
 */
public class SellingCarFragment extends Fragment implements View.OnClickListener {

    CardView carSellingItem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_selling_cars, container, false);
        carSellingItem = (CardView) v.findViewById(R.id.carSellingItem);
        carSellingItem.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.carSellingItem:
                Intent intent = new Intent(getActivity(), BidPriceActivity.class);
                startActivity(intent);
                break;
        }
    }
}
