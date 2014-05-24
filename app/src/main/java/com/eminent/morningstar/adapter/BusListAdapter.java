package com.eminent.morningstar.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eminent.morningstar.R;
import com.eminent.morningstar.activities.SeatSelectionActivity;
import com.eminent.morningstar.model.BusInfo;
import com.eminent.morningstar.utils.LocalPreferences;
import com.eminent.morningstar.utils.Utils;

import java.util.ArrayList;

public class BusListAdapter extends BaseAdapter {
    private class ViewHolder {
        private TextView mModelView;
        private TextView mTimeView;
        private TextView mAvailableSeatsView;
        private TextView mCostView;
        private RelativeLayout mCellLayout;
    }

    private ArrayList<BusInfo> mItems;
    private LayoutInflater mLayoutInflator = null;
    private Context mContext = null;

    public BusListAdapter(Context ctx){
        mContext = ctx;
        mLayoutInflator = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mItems = new ArrayList<BusInfo>();
    }

    public void addItem(BusInfo item){
        mItems.add(item);
        notifyDataSetChanged();
    }

    public void clearAllItems(){
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        final BusInfo info = mItems.get(i);
        if(null == view){
            view = mLayoutInflator.inflate(R.layout.bus_info,null);
            holder = new ViewHolder();
            holder.mModelView = (TextView)view.findViewById(R.id.id_model_text);
            holder.mTimeView = (TextView)view.findViewById(R.id.id_time_text);
            holder.mAvailableSeatsView = (TextView)view.findViewById(R.id.id_available_seats_text);
            holder.mCostView = (TextView)view.findViewById(R.id.id_cost_text);
            holder.mCellLayout = (RelativeLayout)view.findViewById(R.id.id_bus_info_cell);
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        /*if(0 == i%2){
            holder.mCellLayout.setBackgroundResource(R.drawable.bus_info_cell_background);
        }else{
            holder.mCellLayout.setBackgroundResource(R.drawable.bus_info_cell_background_1);
        }*/

        holder.mCellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocalPreferences.storeCurrentBusInfo(info);
                Intent intent = new Intent(mContext, SeatSelectionActivity.class);
                mContext.startActivity(intent);
            }
        });

        if(null != info.getBusStyle()){
            holder.mModelView.setText(info.getBusStyle());
        }

        String durationText = null;
        if(info.getEndTime() >= info.getStartTime()){
            durationText = String.format("%.2f",(info.getEndTime() - info.getStartTime()));
        }else{
            durationText = String.format("%.2f", ((info.getEndTime() + 24) - info.getStartTime()));
        }

        String timeText = Utils.getTimeString(info.getStartTime()) +"-"+Utils.getTimeString(info.getEndTime()) +" ("+durationText+" hours)";
        holder.mTimeView.setText(timeText);

        String availableSeatsText = String.valueOf(info.getAvailableSeats())+" seats available";
        holder.mAvailableSeatsView.setText(availableSeatsText);

        String costText = "RS "+String.format("%.2f", info.getPrice());
        holder.mCostView.setText(costText);

        return view;
    }
}
