package com.example.waiter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waiter.Adapter.RevenueAdapter;
import com.example.waiter.database.RevenueDatabase;
import com.example.waiter.model.Revenue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RevenueActivity extends AppCompatActivity {
    TextView tvDateRevenu, tvYearRevenu, tvMonthRevenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewR);
        ImageView button = findViewById(R.id.img_TableofRevenue);
        tvDateRevenu = findViewById(R.id.tv_DateRevenue);
        tvMonthRevenu = findViewById(R.id.tv_MonthRevenue);
        tvYearRevenu = findViewById(R.id.tv_YearRevenue);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("dd");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        String datetime = date.format(c.getTime());
        String monthtime = month.format(c.getTime());
        Log.d("xuan",monthtime);
        String yeartime = year.format(c.getTime());
        String timeT = time.format(c.getTime());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RevenueActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        RevenueDatabase database = new RevenueDatabase(RevenueActivity.this);
        ArrayList<Revenue> revenue = database.getAllR();
        int sumdate = 0;
        int summonth = 0;
        int sumyear = 0;
        for (Revenue m: revenue){
            if (datetime.equals(m.getDate()) && monthtime.equals(m.getMonth()) && yeartime.equals(m.getYear())){
                 sumdate += m.getMoney();

            }
            if ( monthtime.equals(m.getMonth()) && yeartime.equals(m.getYear())){
                summonth += m.getMoney();

            }
            if (yeartime.equals(m.getYear())){
                sumyear += m.getMoney();

            }
        }
        tvDateRevenu.setText(sumdate+" VND");
        tvMonthRevenu.setText(summonth+ " VND");
        tvYearRevenu.setText(sumyear+ " VND");



        RevenueAdapter revenueAdapter = new RevenueAdapter(revenue, RevenueActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(revenueAdapter);
    }
}