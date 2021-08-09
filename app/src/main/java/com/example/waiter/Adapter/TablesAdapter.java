package com.example.waiter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waiter.database.BillDatabase;
import com.example.waiter.MenuActivity;
import com.example.waiter.R;
import com.example.waiter.model.Tables;

import java.util.ArrayList;

public class TablesAdapter extends RecyclerView.Adapter<TablesAdapter.MyViewHolder> {
    private ArrayList<Tables> tablesArrayList;
    private Context context;

    public TablesAdapter(ArrayList<Tables> tablesArrayList, Context context) {
        this.tablesArrayList = tablesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tables,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tables tables = tablesArrayList.get(position);
        holder.textView.setText(tables.getTable());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MenuActivity.class);
                intent.putExtra("Name table", tables.getTable());
                context.startActivity(intent);


            }
        });
        BillDatabase database = new BillDatabase(context,tables.getTable() );
        if (database.getAll().size() > 0){
            holder.imgtable.setImageResource(R.drawable.table1);
        }else{
            holder.imgtable.setImageResource(R.drawable.table);
        }


    }

    @Override
    public int getItemCount() {
        return tablesArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgtable;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgtable = itemView.findViewById(R.id.img_table);
            textView = itemView.findViewById(R.id.tv_tables);
        }
    }
}
