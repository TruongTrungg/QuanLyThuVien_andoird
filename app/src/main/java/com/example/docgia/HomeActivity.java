package com.example.docgia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Button btdocgia,btsach,btmuonsach,btBaoCao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Quản Lý Thư Viện");
        setControl();
        setEvent();
    }

    private void setEvent() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.navdocgia) {
                    Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                    Toast.makeText(HomeActivity.this, "Độc Giả", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }
                if (item.getItemId() == R.id.navQuayLySach) {
                    Intent intent = new Intent(HomeActivity.this,SachActivity.class);
                    Toast.makeText(HomeActivity.this, "Sách", Toast.LENGTH_SHORT).show();
                    startActivity(intent);


                }
                if (item.getItemId() == R.id.navThongKe) {
                    Intent intent = new Intent(HomeActivity.this,BaoCaoActivity.class);
                    Toast.makeText(HomeActivity.this, "Thống Kê", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }
                if (item.getItemId() == R.id.navMuonTraSach) {
                    Intent intent = new Intent(HomeActivity.this,MuonsachActivity.class);
                    Toast.makeText(HomeActivity.this, "Mượn Trả Sách", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }
                return false;
            }
        });




        btdocgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btmuonsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,MuonsachActivity.class);
                startActivity(intent);
            }
        });
        btsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,SachActivity.class);
                startActivity(intent);
            }
        });
        btBaoCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,BaoCaoActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);


    }
    private void setControl() {
        btBaoCao = findViewById(R.id.btBaoCao);
        btdocgia= findViewById(R.id.btdocgia);
        btmuonsach = findViewById(R.id.btmuontrasach);
        btsach = findViewById(R.id.btsach);
        drawerLayout = findViewById(R.id.drawlayoyt);
        navigationView = findViewById(R.id.navView);
    }
}