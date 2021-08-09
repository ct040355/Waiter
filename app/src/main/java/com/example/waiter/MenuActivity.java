package com.example.waiter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waiter.Adapter.HomeAdapter;
import com.example.waiter.database.BillDatabase;
import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView table;
    private ImageView backMenu,imgBill;
    private String myString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        fragment();
        table = findViewById(R.id.tv_nameTable);
        backMenu = findViewById(R.id.backMenu);
        imgBill = findViewById(R.id.image_bill);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intent2);
            }
        });
        imgBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = (String) getIntent().getSerializableExtra("Name table");
                Intent intent = new Intent(MenuActivity.this,BillActivity.class);
                intent.putExtra("Name", name);
                startActivity(intent);
            }
        });

        String nameTable = (String) getIntent().getSerializableExtra("Name table");
        table.setText(nameTable);
        BillDatabase database = new BillDatabase(this, nameTable);
        myString = nameTable;

    }
    private void fragment() {
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        HomeAdapter homeAdapter = new HomeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(homeAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    public String getMyData() {
        return myString;
    }

}