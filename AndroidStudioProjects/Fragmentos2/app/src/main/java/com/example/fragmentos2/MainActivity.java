package com.example.fragmentos2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btRojo, btVerde;
    FragmentTransaction transaccion;
    Fragment fragRojo, fragVerde, fragInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRojo = findViewById(R.id.btRojo);
        btVerde = findViewById(R.id.btVerde);
        fragInicio = new InicioFragment();
        fragRojo = new fragmentoRojo();
        fragVerde = new FragmentoVerde();

        transaccion = getSupportFragmentManager().beginTransaction();
        transaccion.add(R.id.contenedorFragmento, fragInicio).commit();

        btRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaccion = getSupportFragmentManager().beginTransaction();
                transaccion.replace(R.id.contenedorFragmento, fragRojo).commit();
                transaccion.addToBackStack(null);
            }
        });

        btVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaccion = getSupportFragmentManager().beginTransaction();
                transaccion.replace(R.id.contenedorFragmento, fragVerde).commit();
                transaccion.addToBackStack(null);
            }
        });
    }
}