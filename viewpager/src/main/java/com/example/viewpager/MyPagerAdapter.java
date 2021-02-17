package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    int numTabs; //탭의 개수
    public MyPagerAdapter(@NonNull FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs=numTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentEx1 f1=new FragmentEx1();
                return f1;
            case 1:
                FragmentEx2 f2=new FragmentEx2();
                return f2;
            case 2:
                FragmentEx3 f3=new FragmentEx3();
                return f3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
