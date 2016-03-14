package cadark.korean.hey.cadarkver9.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cadark.korean.hey.cadarkver9.R;
import cadark.korean.hey.cadarkver9.adapter.RFAdapterListCarHome;
import cadark.korean.hey.cadarkver9.api_retrofit.RFApi;
import cadark.korean.hey.cadarkver9.models.CarListHomeModel;


/**
 * Created by Hey.Hung on 2/25/2016.
 */
public class HomeListcarFragment extends Fragment {
    private static final String TAG = "HomeListcarFragment";
    private ListView listViewCar;
    private RFAdapterListCarHome adapterContact;
    ArrayList<CarListHomeModel> arrListCar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        listViewCar = (ListView) v.findViewById(R.id.listViewCar);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        adapterContact = new RFAdapterListCarHome(getActivity(), R.layout.item_list_car, arrListCar);
        listViewCar.setAdapter(adapterContact);
    }

    private void initView() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Log.i(TAG, "vào đây");
        arrListCar = RFApi.getContact();
        listViewCar.setDescendantFocusability(ListView.FOCUS_BLOCK_DESCENDANTS);
        listViewCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Position" + position, Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "11111", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailCarActivity.class);
                startActivity(intent);
            }
        });
    }
}
