package com.example.waiter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.waiter.database.BillDatabase;
import com.example.waiter.R;
import com.example.waiter.model.Bill;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.MyViewHolder> {
    private ArrayList<Bill> billArrayList;
    private Context context;
    private Intent mIntent;
    private AppCompatActivity activity;




    public BillAdapter(ArrayList<Bill> billArrayList, Context context, AppCompatActivity activity) {
        this.billArrayList = billArrayList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BillAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bill,parent,false);
        return new BillAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillAdapter.MyViewHolder holder, int position) {
        Bill bill = billArrayList.get(position);
        Glide.with(holder.imageBill)
                .load(bill.getImageBill())
                .into(holder.imageBill);
        holder.nameItemBill.setText(bill.getNameBill());
        holder.priceItemBill.setText("Giá: " + bill.getPriceBill() +" VND");
        holder.quantityItemBill.setText("Số lượng: " + bill.getQuantityBill());
        holder.tItemBill.setText( bill.gettBill()+" VND");

        String name = getmIntent().getStringExtra("name");
        BillDatabase database = new BillDatabase(context,name );

        holder.imgCanle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.delete(bill);
                notifyItemRemoved(position);
                Toast.makeText(context,"Đã xóa "+ bill.getNameBill(),Toast.LENGTH_SHORT).show();
                activity.onBackPressed();
            }
        });

    }

    @Override
    public int getItemCount() {
        return billArrayList.size();
    }

    public Intent getmIntent() {
        return mIntent;
    }

    public void setmIntent(Intent mIntent) {
        this.mIntent = mIntent;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameItemBill ,priceItemBill,quantityItemBill,tItemBill;
        ImageView imageBill, imgCanle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameItemBill = itemView.findViewById(R.id.tv_nameItemBill);
            priceItemBill = itemView.findViewById(R.id.tv_priceItemBill);
            tItemBill = itemView.findViewById(R.id.tv_tItemBill);
            quantityItemBill = itemView.findViewById(R.id.tv_quanityItemBill);
            imageBill = itemView.findViewById(R.id.img_ItemBill);
            imgCanle = itemView.findViewById(R.id.img_cancleBill);

        }
    }
}
