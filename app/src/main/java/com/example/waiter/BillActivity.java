package com.example.waiter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waiter.Adapter.BillAdapter;
import com.example.waiter.database.BillDatabase;
import com.example.waiter.database.RevenueDatabase;
import com.example.waiter.model.Bill;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BillActivity extends AppCompatActivity {
    ImageView backBill,backTable;
    RecyclerView recyclerView;
    TextView nameTableBill;
    TextView tvSum, tvPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);


        backBill = findViewById(R.id.img_backBill);
        backTable = findViewById(R.id.img_BackTable);
        recyclerView = findViewById(R.id.recyclerViewBill);
        nameTableBill = findViewById(R.id.tv_nameTableBill);
        tvSum = findViewById(R.id.tv_sum);
        tvPay = findViewById(R.id.tv_pay);



        backBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        backTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        String name = (String) getIntent().getSerializableExtra("Name");
        nameTableBill.setText(name);


        BillDatabase database = new BillDatabase(this, name);
        ArrayList<Bill> bills   = database.getAll() ;

        int summ=0;
        for(Bill m :bills){
            summ += m.gettBill();
        }

        int finalSumm = summ;
        tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BillActivity.this);
                builder.setTitle("Table "+name);
                builder.setMessage("Thanh toán "+ finalSumm +" VND");
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

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

                        RevenueDatabase revenueDatabase = new RevenueDatabase(BillActivity.this);
                        revenueDatabase.addRevenue(datetime,monthtime,yeartime,timeT,name,finalSumm);


                        database.deleteAll();
                        Intent intent = new Intent(BillActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });



        tvSum.setText("Tổng: "+summ+" VND");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BillAdapter billAdapter = new BillAdapter(bills,this, BillActivity.this);
        Intent intent = new Intent();
        intent.putExtra("name",name);
        sendToAdapter(intent,billAdapter);
        billAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(billAdapter);
    }

    void sendToAdapter(Intent intent, BillAdapter billAdapter) {
        billAdapter.setmIntent(intent);
    }

}