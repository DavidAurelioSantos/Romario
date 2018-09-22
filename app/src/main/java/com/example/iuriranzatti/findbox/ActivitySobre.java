package com.example.iuriranzatti.findbox;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActivitySobre extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
    }

    //Aqui ativa o menu hambuguer
//    ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
//            drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
//
//        @Override
//        public void onDrawerClosed(View v) {
//            super.onDrawerClosed(v);
//        }
//
//        @Override
//        public void onDrawerOpened(View v) {
//            super.onDrawerOpened(v);
//        }
//    };

//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
}
