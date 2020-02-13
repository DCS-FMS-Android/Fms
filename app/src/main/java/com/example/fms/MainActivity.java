package com.example.fms;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    RecyclerView storyRecyclerView;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent();
         id = getIntent().getStringExtra("id");
        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        storyRecyclerView = (RecyclerView) findViewById(R.id.busniss_recycle);
        storyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        storyRecyclerView.setAdapter(new details_recyclerview_adapter(this));


        toolbar = (Toolbar) findViewById(R.id.articleToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.articleDrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        navigationView = (NavigationView) findViewById(R.id.articleNavigationView);

        SetUpNavigation();

    }

    private void SetUpNavigation() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.summry:

                        break;
                    case R.id.bank:
                        Intent intent = new Intent(MainActivity.this, BankAccounts.class);
                        intent.putExtra("b_id",id);
                        Activity activity = (Activity) MainActivity.this;
                        activity.startActivity(intent);
                        overridePendingTransition(R.anim.start, R.anim.exit);


                        break;
                    case R.id.cos:

                        break;
                }
                return true;
            }
        });
    }


}