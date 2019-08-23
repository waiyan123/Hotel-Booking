package itachi_waiyan.com.hotel_booking_app_assignment4;

import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import itachi_waiyan.com.hotel_booking_app_assignment4.adapters.MainViewPagerAdapter;
import itachi_waiyan.com.hotel_booking_app_assignment4.delegate.EventHotelItemDelegate;
import itachi_waiyan.com.hotel_booking_app_assignment4.fragments.BookmarkFragment;
import itachi_waiyan.com.hotel_booking_app_assignment4.fragments.HomeFragment;
import itachi_waiyan.com.hotel_booking_app_assignment4.fragments.ScheduleFragment;
import itachi_waiyan.com.hotel_booking_app_assignment4.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements EventHotelItemDelegate {

    ViewPager viewPager;
    MainViewPagerAdapter adapter;
    TabLayout tabs;
    Fragment fragmentHome, fragmentBookmark, fragmentSearch, fragmentSchedule;
    LinearLayout bottomSheet;
    BottomSheetBehavior sheetBehavior;
    Spinner spinner;
    CardView filterNow;
    View dialogView;
    BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomSheet = findViewById(R.id.ll_bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottomSheet);

        viewPager = findViewById(R.id.main_view_pager);
        tabs = findViewById(R.id.main_tab_layout);
        tabs.setupWithViewPager(viewPager);
        setupWithViewPager(viewPager);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.purple);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.iconColorSecondary);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.purple);
        tabs.getTabAt(0).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);


        spinner = findViewById(R.id.spinner2);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.price_array, R.layout.spinner_item);

        spinner.getBackground().setColorFilter(getResources().getColor(R.color.textColorSecondary), PorterDuff.Mode.SRC_ATOP);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    private void setupWithViewPager(ViewPager vp) {

        fragmentHome = new HomeFragment();
        fragmentBookmark = new BookmarkFragment();
        fragmentSchedule = new ScheduleFragment();
        fragmentSearch = new SearchFragment();
        adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(fragmentHome, "Home");
        adapter.addFragment(fragmentSearch, "Search");
        adapter.addFragment(fragmentSchedule, "Schedule");
        adapter.addFragment(fragmentBookmark, "Bookmark");
        viewPager.setAdapter(adapter);
        tabs.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_home));
        tabs.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_search));
        tabs.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.ic_date_range));
        tabs.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.ic_bookmark_border));


    }

    @Override
    public void onTabEventItem() {

        dialog = new BottomSheetDialog(MainActivity.this);
        dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
        dialog.setContentView(dialogView);
        dialog.show();

    }
}
