package itachi_waiyan.com.hotel_booking_app_assignment4.fragments;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import itachi_waiyan.com.hotel_booking_app_assignment4.R;
import itachi_waiyan.com.hotel_booking_app_assignment4.adapters.HomeViewPagerAdapter;

public class HomeFragment extends Fragment {

    Spinner spinner;
    ViewPager viewPager ;
    TabLayout tabs;
    HomeViewPagerAdapter adapter;
    Fragment nearByFragment,popularFragment,allFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        viewPager = view.findViewById(R.id.home_view_pager);
        spinner = view.findViewById(R.id.spinner);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(container.getContext(),
                R.array.spinner_array, R.layout.spinner_item);

        spinner.getBackground().setColorFilter(getResources().getColor(R.color.textColorSecondary), PorterDuff.Mode.SRC_ATOP);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

        tabs = view.findViewById(R.id.home_tab_layout);
        tabs.setupWithViewPager(viewPager);
        setUpWithViewPager(viewPager);
        return view;
    }

    public void setUpWithViewPager(ViewPager vp){
        nearByFragment = new NearByFragment();
        popularFragment = new NearByFragment();
        allFragment = new NearByFragment();
        adapter = new HomeViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(nearByFragment,"Nearby");
        adapter.addFragment(popularFragment,"Popular");
        adapter.addFragment(allFragment,"All");
        viewPager.setAdapter(adapter);
    }
}
