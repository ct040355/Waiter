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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.waiter.database.BillDatabase;
import com.example.waiter.R;
import com.example.waiter.model.Menu;

import java.util.ArrayList;

public class BlistAdapter extends RecyclerView.Adapter<BlistAdapter.MyViewHolder> {
    private ArrayList<Menu> menuArrayList;
    private Context context;
    private Intent mIntent;

    public BlistAdapter(ArrayList<Menu> menuArrayList, Context context) {
        this.menuArrayList = menuArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BlistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_b,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlistAdapter.MyViewHolder holder, int position) {
        Menu menu = menuArrayList.get(position);
        Glide.with(holder.thumbImageB)
                .load(menu.getThumbImage())
                .into(holder.thumbImageB);
        holder.tvNameMenusB.setText(menu.getNameMenu());
        holder.tvPriceMenuB.setText("Giá: " +menu.getPriceMenu()+ " VND");
        holder.imgPlusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = menu.getQuantity();
                quantity++;
                menu.setQuantity(quantity);
                holder.tvCountB.setText(String.valueOf(quantity));

            }

        });

        holder.imgMinusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = menu.getQuantity();
                if(quantity > 0){
                    quantity--;
                    menu.setQuantity(quantity);
                    holder.tvCountB.setText(String.valueOf(quantity));

                }
            }
        });
        String name = getmIntent().getStringExtra("table");
        BillDatabase database = new BillDatabase(context,name );
        holder.imgAddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(menu.getQuantity() > 0 ){
                    database.addBill(menu.getThumbImage(),
                            menu.getNameMenu(),
                            menu.getPriceMenu(),
                            menu.getQuantity(),
                            menu.getPriceMenu()*menu.getQuantity());

                    menu.setQuantity(0);
                    holder.tvCountB.setText(""+menu.getQuantity());
                    Toast.makeText(context,"Thêm vào Bill thành công",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }

    public Intent getmIntent() {
        return mIntent;
    }

    public void setmIntent(Intent mIntent) {
        this.mIntent = mIntent;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbImageB, imgMinusB, imgPlusB, imgAddB;
        TextView tvNameMenusB, tvCountB, tvPriceMenuB;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbImageB = itemView.findViewById(R.id.thumbImageB);
            imgMinusB = itemView.findViewById(R.id.img_minusB);
            imgPlusB = itemView.findViewById(R.id.img_plusB);
            tvNameMenusB = itemView.findViewById(R.id.tv_NameMenuB);
            tvCountB = itemView.findViewById(R.id.tv_CountB);
            imgAddB = itemView.findViewById(R.id.image_AddB);
            tvPriceMenuB = itemView.findViewById(R.id.tv_PriceMenuB);
        }
    }
}

