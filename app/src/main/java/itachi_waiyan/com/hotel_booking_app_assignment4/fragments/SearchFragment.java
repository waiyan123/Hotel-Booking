package itachi_waiyan.com.hotel_booking_app_assignment4.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import itachi_waiyan.com.hotel_booking_app_assignment4.R;
import itachi_waiyan.com.hotel_booking_app_assignment4.adapters.HotelRecyclerViewAdapter;
import itachi_waiyan.com.hotel_booking_app_assignment4.adapters.RecentSearchRecyclerViewAdapter;
import itachi_waiyan.com.hotel_booking_app_assignment4.delegate.EventHotelItemDelegate;

public class SearchFragment extends Fragment {

    RecyclerView rvTopSearch,rvRecentSearch;
    LinearLayout filterLayout;
    EventHotelItemDelegate mEventItemDelegate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        rvTopSearch = view.findViewById(R.id.rv_top_search);
        rvRecentSearch = view.findViewById(R.id.rv_recent_search);
        RecentSearchRecyclerViewAdapter adapter = new RecentSearchRecyclerViewAdapter();
        rvTopSearch.setAdapter(adapter);
        rvTopSearch.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.HORIZONTAL,false));
        rvRecentSearch.setAdapter(adapter);
        rvRecentSearch.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.HORIZONTAL,false));

        filterLayout = view.findViewById(R.id.filter_layout);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mEventItemDelegate = (EventHotelItemDelegate) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        filterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEventItemDelegate.onTabEventItem();
            }
        });


    }
}
