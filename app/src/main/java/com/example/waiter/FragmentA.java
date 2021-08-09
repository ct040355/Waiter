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
import com.example.waiter.model.Menu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FragmentA extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
       MenuActivity activity = (MenuActivity) getActivity();
        String myDataFromActivity = activity.getMyData();


        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewA);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Menu>>(){}.getType();
        String menujson= "[\n" +
                "    {\n" +
                "      \"thumbImage\": \"https://nghienbep.com/media/Review-T%C3%A0o-ph%E1%BB%9B-truy%E1%BB%81n-th%E1%BB%91ng-1.jpg\",\n" +
                "      \"nameMenu\": \"Tào phớ truyền thống\",\n" +
                "      \"priceMenu\": 5000\n" +
                "    },\n" +
                "    {\n" +
                "      \"thumbImage\": \"https://toplist.vn/images/800px/vua-tao-pho-262872.jpg\",\n" +
                "      \"nameMenu\": \"Tào phớ Mix thạch\",\n" +
                "      \"priceMenu\": 7000\n" +
                "    },\n" +
                "   {\n" +
                "      \"thumbImage\": \"https://nghienbep.com/media/98172962_1100184010350713_5698396616436744192_o.jpg_nc_cat1_nc_sidca434c_nc_ohcsYq_ImSD6j4AX_2s4gC_nc_htscontent.fhan2-3.fnaoh685488f5e3243248997e8fe9ffeda4a4oe5EEC509D-e1589991932478.jpeg\",\n" +
                "      \"nameMenu\": \"Tào phớ trân châu thập cẩm\",\n" +
                "      \"priceMenu\": 8000\n" +
                "    },\n" +
                "   {\n" +
                "      \"thumbImage\": \"https://tikibook.com/upload/news/092020/tao-pho-nghia-tan-anh-em-quan-1.jpg\",\n" +
                "      \"nameMenu\": \"Tào phớ trân châu cốt dừa\",\n" +
                "      \"priceMenu\": 10000\n" +
                "    },\n" +
                "   {\n" +
                "      \"thumbImage\": \"https://www.foodpanda.vn/wp-content/uploads/2019/03/tao-pho-tra-xanh.jpg\",\n" +
                "      \"nameMenu\": \"Tào phớ trà xanh\",\n" +
                "      \"priceMenu\": 10000\n" +
                "    },\n" +
                "   {\n" +
                "      \"thumbImage\": \"https://images.foody.vn/res/g8/77695/s750x750/d5987c4a-3b5f-417c-a0c2-8c3fdc8710be.jpg\",\n" +
                "      \"nameMenu\": \"Tào phớ đậu đỏ\",\n" +
                "      \"priceMenu\": 10000\n" +
                "    },\n" +
                "   \n" +
                "    {\n" +
                "      \"thumbImage\": \"https://www.foodpanda.vn/wp-content/uploads/2019/03/tao-pho-hat-sen.jpg\",\n" +
                "      \"nameMenu\": \"Tào phớ hoa nhài\",\n" +
                "      \"priceMenu\": 10000\n" +
                "    }\n" +
                "  ]";
        List<Menu> menus = gson.fromJson(menujson, listType);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        AlistAdapter alistAdapter = new AlistAdapter((ArrayList<Menu>) menus,getContext());


        Intent intent = new Intent();
        intent.putExtra("table",myDataFromActivity);
        sendIntentToAdapter(intent,alistAdapter);
        recyclerView.setAdapter(alistAdapter);
        return view;
    }
    void sendIntentToAdapter(Intent intent, AlistAdapter alistAdapter) {
        alistAdapter.setmIntent(intent);
    }

}