package com.example.fragmentos3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fragmentos3.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Menu menu;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new fragmentoInicio()).commit();

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.inicio)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new fragmentoInicio()).commit();

                }
                else if(item.getItemId() == R.id.perfil)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new fragmentoPerfil()).commit();

                }
                else if(item.getItemId() == R.id.notificaciones)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new fragmentoNotificaciones()).commit();

                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


}