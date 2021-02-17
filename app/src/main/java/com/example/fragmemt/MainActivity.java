package com.example.fragmemt;

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
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong, tabArtist, tabAlbum;
    MyTabFragment myFrags[]=new MyTabFragment[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActionBar bar=getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        tabSong=bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);
        bar.addTab(tabSong);
        tabArtist=bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);
        bar.addTab(tabArtist);
        tabAlbum=bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);
        bar.addTab(tabAlbum);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFragment=null;
        if(myFrags[tab.getPosition()]==null){
            myTabFragment=new MyTabFragment();
            Bundle data=new Bundle();
            data.putString("tabName", tab.getText().toString());
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
    public static  class MyTabFragment extends Fragment{
        String tabName;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            tabName=data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            LinearLayout layout=new LinearLayout(super.getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setLayoutParams(params);
            if(tabName.equals("음악별")){
                layout.setBackgroundColor(Color.rgb(152,0,152));
                Button btn1=new Button(super.getContext());
                btn1.setText("나는 버튼");
                layout.addView(btn1);
            } else if(tabName.equals("가수별")){
                layout.setBackgroundColor(Color.BLUE);
            } else if(tabName.equals("앨범별")){
                layout.setBackgroundColor(Color.BLUE);
            }
            return layout;
        }
    }
}