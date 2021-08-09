package com.example.waiter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.waiter.Adapter.TablesAdapter;
import com.example.waiter.model.Tables;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imgrevenue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Tables> tables = new ArrayList<>();
        for (int i = 1; i < 25; i++) {
            tables.add(new Tables(""+i, R.drawable.table));

        }
        imgrevenue = findViewById(R.id.img_Revenue);
        imgrevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RevenueActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        TablesAdapter tablesAdapter = new TablesAdapter(tables,this);
        tablesAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(tablesAdapter);

    }

}