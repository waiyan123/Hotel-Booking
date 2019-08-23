package itachi_waiyan.com.hotel_booking_app_assignment4.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import itachi_waiyan.com.hotel_booking_app_assignment4.R;
import itachi_waiyan.com.hotel_booking_app_assignment4.viewholders.RvHoltelViewHolder;

public class RecentSearchRecyclerViewAdapter extends RecyclerView.Adapter{
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_recent_search_item_view,viewGroup,false);
        return new RvHoltelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
