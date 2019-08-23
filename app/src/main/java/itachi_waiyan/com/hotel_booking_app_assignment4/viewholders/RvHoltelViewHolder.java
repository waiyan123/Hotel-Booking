package itachi_waiyan.com.hotel_booking_app_assignment4.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import itachi_waiyan.com.hotel_booking_app_assignment4.delegate.EventHotelItemDelegate;

public class RvHoltelViewHolder extends RecyclerView.ViewHolder {

    private EventHotelItemDelegate eventHotelItemDelegate;

    public RvHoltelViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                eventHotelItemDelegate.onTabEventItem();
            }
        });
    }
}
