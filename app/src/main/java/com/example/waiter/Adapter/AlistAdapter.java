package com.example.waiter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.example.waiter.database.BillDatabase;
import com.example.waiter.model.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waiter.R;

import java.util.ArrayList;

public class AlistAdapter extends RecyclerView.Adapter<AlistAdapter.MyViewHolder> {
    private ArrayList<Menu>  menuArrayList;
    private Context context;
    private Intent mIntent;

    public AlistAdapter(ArrayList<Menu> menuArrayList, Context context) {
        this.menuArrayList = menuArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_a,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Menu menu = menuArrayList.get(position);
        Glide.with(holder.thumbImage)
                .load(menu.getThumbImage())
                .into(holder.thumbImage);

        holder.tvNameMenus.setText(menu.getNameMenu());
        holder.tvPriceMenu.setText("Giá: " +menu.getPriceMenu()+ " VND");
        holder.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = menu.getQuantity();
                quantity++;
                menu.setQuantity(quantity);
                holder.tvCount.setText(String.valueOf(quantity));

            }

        });

        holder.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = menu.getQuantity();
                if(quantity > 0){
                    quantity--;
                    menu.setQuantity(quantity);
                    holder.tvCount.setText(String.valueOf(quantity));

                    }
                }
        });
        String name = getmIntent().getStringExtra("table");
        BillDatabase database = new BillDatabase(context,name );
        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(menu.getQuantity() > 0 ){
                        database.addBill(menu.getThumbImage(),
                                menu.getNameMenu(),
                                menu.getPriceMenu(),
                                menu.getQuantity(),
                                menu.getPriceMenu()*menu.getQuantity());

                        menu.setQuantity(0);
                        holder.tvCount.setText(""+menu.getQuantity());
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
        ImageView thumbImage, imgMinus, imgPlus, imgAdd;
        TextView tvNameMenus, tvCount, tvPriceMenu;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbImage = itemView.findViewById(R.id.thumbImage);
            imgMinus = itemView.findViewById(R.id.img_minus);
            imgPlus = itemView.findViewById(R.id.img_plus);
            tvNameMenus = itemView.findViewById(R.id.tv_NameMenu);
            tvCount = itemView.findViewById(R.id.tv_Count);
            imgAdd = itemView.findViewById(R.id.image_Add);
            tvPriceMenu = itemView.findViewById(R.id.tv_PriceMenu);
        }
    }
}
