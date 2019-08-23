package itachi_waiyan.com.hotel_booking_app_assignment4.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itachi_waiyan.com.hotel_booking_app_assignment4.R;
import itachi_waiyan.com.hotel_booking_app_assignment4.adapters.HotelRecyclerViewAdapter;

public class NearByFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby,container,false);
        RecyclerView rvHotel = view.findViewById(R.id.rv_hotel);
        HotelRecyclerViewAdapter adapter = new HotelRecyclerViewAdapter();
        rvHotel.setAdapter(adapter);
        rvHotel.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));
        return view;
    }
}
