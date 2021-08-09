package com.example.waiter;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.waiter.Adapter.AlistAdapter;
import com.example.waiter.Adapter.BlistAdapter;
import com.example.waiter.model.Menu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class FragmentB extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        MenuActivity activity = (MenuActivity) getActivity();
        String myDataFromActivity = activity.getMyData();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewB);


        Gson gson = new Gson();
        Type listType = new TypeToken<List<Menu>>(){}.getType();
        String menujson= "[\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://cdn.beptruong.edu.vn/wp-content/uploads/2019/03/sua-chua-nep-cam.jpg\",\n" +
                "    \"nameMenu\" : \"Sữa chua nếp cẩm\",\n" +
                "    \"priceMenu\" : 10000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://ameovat.com/wp-content/uploads/2016/03/cach-lam-sua-chua-mit.jpg\",\n" +
                "    \"nameMenu\" : \"Sữa chua mít\",\n" +
                "    \"priceMenu\" : 13000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://momkitty.com/wp-content/uploads/2017/05/cach-lam-thach-sua-chua-2.jpg\",\n" +
                "    \"nameMenu\" : \"Sữa chua thạch\",\n" +
                "    \"priceMenu\" : 12000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://cdn.tgdd.vn/Files/2020/12/16/1314177/cach-lam-sua-chua-tran-chau-ha-long-ngon-chuan-nhu-ngoai-tiem-202012161516239807.jpg\",\n" +
                "    \"nameMenu\" : \"Sữa chua trân châu\",\n" +
                "    \"priceMenu\" : 15000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://www.thatlangon.com/wp-content/uploads/2020/04/cach-lam-sua-chua-tra-cay-ngon-e1588166843538-480x270.jpg\",\n" +
                "    \"nameMenu\" : \"Hoa quả dầm sữa chua\",\n" +
                "    \"priceMenu\" : 15000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://media.cooky.vn/recipe/g4/31239/s/cooky-recipe-636626070183679330.jpg\",\n" +
                "    \"nameMenu\" : \"Chè khúc bạch\",\n" +
                "    \"priceMenu\" : 20000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://beptruong.edu.vn/wp-content/uploads/2017/07/che-buoi.jpg\",\n" +
                "    \"nameMenu\" : \"Chè bưởi\",\n" +
                "    \"priceMenu\" : 12000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://cdn.chanhtuoi.com/uploads/2018/06/w400/cach-nau-che-thap-cam-4.jpg.webp\",\n" +
                "    \"nameMenu\" : \"Chè thập cẩm\",\n" +
                "    \"priceMenu\" : 12000\n" +
                "  },\n" +
                "  \n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://toplist.vn/images/800px/che-bobo-chacha-92-cua-bac-275607.jpg\",\n" +
                "    \"nameMenu\" : \"Chè hoa quả\",\n" +
                "    \"priceMenu\" : 12000\n" +
                "  }\n" +
                "]";

        List<Menu> menus = gson.fromJson(menujson, listType);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        BlistAdapter blistAdapter = new BlistAdapter((ArrayList<Menu>) menus,getContext());

        Intent intent = new Intent();
        intent.putExtra("table",myDataFromActivity);
        sendIntentToAdapter(intent,blistAdapter);
        recyclerView.setAdapter(blistAdapter);
        return view;
    }
    void sendIntentToAdapter(Intent intent, BlistAdapter blistAdapter) {
        blistAdapter.setmIntent(intent);
    }
}