package com.example.fragmenttab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabPet[]=new ActionBar.Tab[4];
    static int iconIDs[]={R.drawable.icon_dog, R.drawable.icon_cat, R.drawable.rabbit, R.drawable.icon_horse};
    static int imgIDs[]={R.drawable.dog, R.drawable.cat, R.drawable.rabbit, R.drawable.horse};
    static String content[]={"강아지", "고양이", "토끼", "조랑말"};
    MyTabFragment myFrags[]=new MyTabFragment[4];
    static int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar =getSupportActionBar();
        bar.setTitle("동물 선택함");
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for(int i=0; i<tabPet.length; i++){
            tabPet[i]=bar.newTab();
            tabPet[i].setIcon(iconIDs[i]);
            tabPet[i].setTabListener(this);
            bar.addTab(tabPet[i]);
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFragment=null;
        pos=tab.getPosition();
        if(myFrags[tab.getPosition()]==null){
            myTabFragment=new MyTabFragment();
            Bundle data=new Bundle();
            data.putInt("iconID", iconIDs[pos]);
            myTabFragment.setArguments(data);
            myFrags[tab.getPosition()]=myTabFragment;
        } else {
            myTabFragment=myFrags[tab.getPosition()];
        }
        ft.replace(android.R.id.content, myTabFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
    public static  class MyTabFragment extends Fragment {
        int iconID;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            iconID=data.getInt("iconID");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View myView=inflater.inflate(R.layout.flagout, null);
            ImageView ivPet=myView.findViewById(R.id.ivPet);
            TextView tvContent=myView.findViewById(R.id.tvContent);
            if(iconID==iconIDs[pos]){
                ivPet.setImageResource(imgIDs[pos]);
                tvContent.setText(content[pos]);
            }
            return myView;
        }
    }
}