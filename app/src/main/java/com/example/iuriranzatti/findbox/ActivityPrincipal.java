package com.example.iuriranzatti.findbox;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.iuriranzatti.findbox.fragments.FragmentPerfil;
//import com.example.iuriranzatti.findbox.fragments.FragmentSobre;

import java.sql.Time;
import java.util.Date;


public class ActivityPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //ActionBarDrawerToggle.setDrawerIndicatorEnabled(false);


    public DrawerLayout drawerLayout;
    private Toolbar toolbar;
    public TextView txtBemVindo;
    public String campoUsuario;
    public String campoUsuario1;
    public NavigationView navigationView;
    public TextView txtUsuMenu;
    public Intent intent;
    public View view;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtBemVindo = (TextView) findViewById(R.id.txtBemVindo);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Como o text esta em outra tela, preciso estanciar informando que ele
        // abrirará uma activity e colocara a informação em outra tela
        View header = navigationView.getHeaderView(0);
        txtUsuMenu = (TextView) header.findViewById(R.id.txtUsuMenu);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        setSupportActionBar(toolbar);

        initNavigationDrawer();
        //initDrawerListener(savedInstanceState);

        // Atualiza o nome do usuário da tela principal
        Intent intent = getIntent();
        Bundle bdlUsuario = intent.getExtras();
        campoUsuario = bdlUsuario.getString("ChaveUsuario");
        txtBemVindo.setText("Bem Vindo " + campoUsuario);
        txtUsuMenu.setText(campoUsuario);

    }

    private void initNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

       if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(ActivityPrincipal.this);
        }
    }
    /*
    private void initDrawerListener(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            MenuItem item = navigationView.getMenu().getItem(0);
            item = null;
            onNavigationItemSelected(item);
        }
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (isNavigationDrawerOpen()) {
            closeNavigationDrawer();
        } else {
            super.onBackPressed();
        }
    }

    protected boolean isNavigationDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavigationDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //codigo novo

        int id = item.getItemId();

            if (id == R.id.fragmentPerfil) {
                Intent intent = new Intent(ActivityPrincipal.this, ActivityPerfil.class);
                startActivity(intent);
            } else if (id == R.id.fragmentAddPedido) {
                Intent intent = new Intent(ActivityPrincipal.this, ActivityAddPedido.class);
                startActivity(intent);
            } else if (id == R.id.fragmentAcomPedido) {
                Intent intent = new Intent(ActivityPrincipal.this, ActivityAcomPedido.class);
                startActivity(intent);
            } else if (id == R.id.fragmentComoFunciona) {
                Intent intent = new Intent(ActivityPrincipal.this, ActivityComoFunciona.class);
                startActivity(intent);
            } else if (id == R.id.fragmentSobre) {
                Intent intent = new Intent(ActivityPrincipal.this, ActivitySobre.class);
                startActivity(intent);
            } else {
                finish();
            }


//        DrawerLayout drawer = (drawerLayout) findViewById(R.id.drawer);
        drawerLayout.closeDrawer(GravityCompat.START);

        item.setChecked(true);
        drawerLayout.closeDrawers();
        selectDrawerItem(item);

        return true;
    }

    public void selectDrawerItem(MenuItem menuItem) {

    //Aqui ativa o menu hambuguer
    ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
            drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

        @Override
        public void onDrawerClosed(View v) {
            super.onDrawerClosed(v);
        }

        @Override
        public void onDrawerOpened(View v) {
            super.onDrawerOpened(v);
        }
    };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_navigation_menu);



    }


}

