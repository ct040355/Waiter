package com.example.waiter.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waiter.R;
import com.example.waiter.model.Revenue;

import java.util.ArrayList;

public class RevenueAdapter extends RecyclerView.Adapter<RevenueAdapter.MyViewHolder> {
    private ArrayList<Revenue> revenueArrayList;
    private Context context;

    public RevenueAdapter(ArrayList<Revenue> revenueArrayList, Context context) {
        this.revenueArrayList = revenueArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_revenue,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Revenue revenue = revenueArrayList.get(position);
        holder.tvDate.setText(revenue.getDate());
        holder.tvMonth.setText("-"+revenue.getMonth());
        holder.tvYear.setText("-"+revenue.getYear());
        holder.tvTime.setText(revenue.getTime());
        Log.d("xuan",revenue.getMonth());
        holder.tvtableRevenue.setText("Table "+revenue.getName());
        holder.tvMoney.setText(revenue.getMoney()+" VND");
    }

    @Override
    public int getItemCount() {
        return revenueArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvMonth, tvYear,tvTime,tvtableRevenue, tvMoney;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_Date);
            tvMonth = itemView.findViewById(R.id.tv_Month);
            tvYear = itemView.findViewById(R.id.tv_Year);
            tvTime = itemView.findViewById(R.id.tv_Time);
            tvtableRevenue = itemView.findViewById(R.id.tv_tableRevenue);
            tvMoney = itemView.findViewById(R.id.tv_Money);
        }
    }
}
