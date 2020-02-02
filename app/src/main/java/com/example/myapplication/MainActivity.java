package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ExpandableListView expandableListView;
    private ExpandableListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.elv);

        adapter=new ExpandableListViewAdapter(this);

        navigation_drawer_show(savedInstanceState);
    }

    private void navigation_drawer_show(Bundle savedInstanceState) {

        NavigationView navigationView = findViewById(R.id.ui_nav_bar);
        expandableListView.setAdapter(adapter);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_event:

                        break;
                    case R.id.nav_weather:

                        break;
                    case R.id.nav_map:

                        break;
                    case R.id.nav_near_by:

                }
                // auto hide after clicking.....
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        Toolbar toolbar = findViewById(R.id.ui_tool_bar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.ui_main_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }
}
