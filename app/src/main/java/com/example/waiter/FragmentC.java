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
import com.example.waiter.Adapter.ClistAdapter;
import com.example.waiter.model.Menu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FragmentC extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        MenuActivity activity = (MenuActivity) getActivity();
        String myDataFromActivity = activity.getMyData();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewC);

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Menu>>(){}.getType();
        String menujson= "[\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://kenhhomestay.com/wp-content/uploads/2020/04/Nem-chua-ran-Ha-Noi-1.jpg\",\n" +
                "    \"nameMenu\" : \"Nem chua rán(đĩa)\",\n" +
                "    \"priceMenu\" : 25000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://food.ibin.vn/images/data/product/do-an-nhe/xuc-xich-chien.jpg\",\n" +
                "    \"nameMenu\" : \"Xúc xích(cái)\",\n" +
                "    \"priceMenu\" : 10000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://cdn.tgdd.vn/2020/09/CookProduct/84-1200x676.jpg\",\n" +
                "    \"nameMenu\" : \"Kim bắp chiên(suất)\",\n" +
                "    \"priceMenu\" : 20000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://media.cooky.vn/recipe/g2/16810/s640/cooky-recipe-635963273395952486.jpg\",\n" +
                "    \"nameMenu\" : \"Bánh gạo chiên\",\n" +
                "    \"priceMenu\" : 20000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://i.pinimg.com/736x/0a/75/73/0a7573698920bed051406b24673ab298.jpg\",\n" +
                "    \"nameMenu\" : \"Bánh gạo cay\",\n" +
                "    \"priceMenu\" : 20000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://wedding.celeb.vn/wp-content/uploads/2019/04/khoai-tay-chien.jpg\",\n" +
                "    \"nameMenu\" : \"Khoai tây chiên\",\n" +
                "    \"priceMenu\" : 20000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://cdn.daylambanh.edu.vn/wp-content/uploads/2020/02/khoai-tay-lac-pho-mai.jpg\",\n" +
                "    \"nameMenu\" : \"Khoai tây lắc phomai\",\n" +
                "    \"priceMenu\" : 20000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://cdn.daynauan.info.vn/wp-content/uploads/2018/06/canh-ga-chien-xu.jpg\",\n" +
                "    \"nameMenu\" : \"Cánh gà\",\n" +
                "    \"priceMenu\" : 25000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://cdn.tgdd.vn/Files/2018/05/28/1091506/cach-lam-ga-ran-vi-nhu-ga-kfc-sieu-ngon-cuc-de-lam-tai-nha.jpg\",\n" +
                "    \"nameMenu\" : \"Đùi gà\",\n" +
                "    \"priceMenu\" : 25000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://image-us.eva.vn/upload/2-2019/images/2019-06-28/cach-lam-bo-kho-thom-ngon-vi-cay-cay-an-cuc-suong-cach-lam-bo-kho-4-1561714292-700-width600height403.jpg\",\n" +
                "    \"nameMenu\" : \"Bò khô\",\n" +
                "    \"priceMenu\" : 20000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://cdn.tgdd.vn/Files/2019/11/30/1223631/4-cach-lam-kho-ga-la-chanh-don-gian-tai-nha-19-760x367.jpg\",\n" +
                "    \"nameMenu\" : \"Khô gà lá chanh\",\n" +
                "    \"priceMenu\" : 20000\n" +
                "  },\n" +
                "  {\n" +
                "    \"thumbImage\" : \"https://anh.eva.vn/upload/2-2017/images/2017-04-27/doc-to-gay-benh-tu-hat-huong-duong-khien-nhieu-nguoi-khiep-so-hathuongduong-1493277343-width500height315.jpg\",\n" +
                "    \"nameMenu\" : \"Hướng dương\",\n" +
                "    \"priceMenu\" : 10000\n" +
                "  }\n" +
                "  \n" +
                "  \n" +
                "]" ;
        List<Menu> menus = gson.fromJson(menujson, listType);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ClistAdapter clistAdapter = new ClistAdapter((ArrayList<Menu>) menus,getContext());

        Intent intent = new Intent();
        intent.putExtra("table",myDataFromActivity);
        sendIntentToAdapter(intent,clistAdapter);
        recyclerView.setAdapter(clistAdapter);
        return view;
    }
    void sendIntentToAdapter(Intent intent, ClistAdapter clistAdapter) {
        clistAdapter.setmIntent(intent);
    }
}