package com.example.waiter.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.waiter.FragmentA;
import com.example.waiter.FragmentB;
import com.example.waiter.FragmentC;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends FragmentPagerAdapter {
    FragmentA fragmentA = new FragmentA();
    FragmentB fragmentB = new FragmentB();
    FragmentC fragmentC = new FragmentC();
    List<Fragment> fragmentList = new ArrayList<>();

    public HomeAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragmentList.add(fragmentA);
        fragmentList.add(fragmentB);
        fragmentList.add(fragmentC);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Tào phớ";
        }
        if (position == 1) {
            return "Chè & SC";
        }
        if(position == 2){
            return "Đồ ăn vặt";
        }
        return super.getPageTitle(position);
    }
}
