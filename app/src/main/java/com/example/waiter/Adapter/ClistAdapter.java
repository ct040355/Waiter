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

public class ClistAdapter extends RecyclerView.Adapter<ClistAdapter.MyViewHolder> {
    private ArrayList<Menu> menuArrayList;
    private Context context;
    private Intent mIntent;

    public ClistAdapter(ArrayList<Menu> menuArrayList, Context context) {
        this.menuArrayList = menuArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ClistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_c,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClistAdapter.MyViewHolder holder, int position) {
        Menu menu = menuArrayList.get(position);
        Glide.with(holder.thumbImageC)
                .load(menu.getThumbImage())
                .into(holder.thumbImageC);

        holder.tvNameMenusC.setText(menu.getNameMenu());
        holder.tvPriceMenuC.setText("Giá: " +menu.getPriceMenu()+ " VND");
        holder.imgPlusC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = menu.getQuantity();
                quantity++;
                menu.setQuantity(quantity);
                holder.tvCountC.setText(String.valueOf(quantity));

            }

        });

        holder.imgMinusC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = menu.getQuantity();
                if(quantity > 0){
                    quantity--;
                    menu.setQuantity(quantity);
                    holder.tvCountC.setText(String.valueOf(quantity));

                }
            }
        });
        String name = getmIntent().getStringExtra("table");
        BillDatabase database = new BillDatabase(context,name );
        holder.imgAddC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(menu.getQuantity() > 0 ){
                    database.addBill(menu.getThumbImage(),
                            menu.getNameMenu(),
                            menu.getPriceMenu(),
                            menu.getQuantity(),
                            menu.getPriceMenu()*menu.getQuantity());

                    menu.setQuantity(0);
                    holder.tvCountC.setText(""+menu.getQuantity());
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
        ImageView thumbImageC, imgMinusC, imgPlusC, imgAddC;
        TextView tvNameMenusC, tvCountC, tvPriceMenuC;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbImageC = itemView.findViewById(R.id.thumbImageC);
            imgMinusC = itemView.findViewById(R.id.img_minusC);
            imgPlusC = itemView.findViewById(R.id.img_plusC);
            tvNameMenusC = itemView.findViewById(R.id.tv_NameMenuC);
            tvCountC = itemView.findViewById(R.id.tv_CountC);
            imgAddC = itemView.findViewById(R.id.image_AddC);
            tvPriceMenuC = itemView.findViewById(R.id.tv_PriceMenuC);
        }
    }
}
