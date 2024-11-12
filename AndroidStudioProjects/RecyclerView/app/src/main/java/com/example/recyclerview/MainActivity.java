package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<Comida> listComida = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));

        listComida.add(new Comida(R.drawable.carne, getResources().getString(R.string.carne)));
        listComida.add(new Comida(R.drawable.crema, getResources().getString(R.string.crema)));
        listComida.add(new Comida(R.drawable.croquetas, getResources().getString(R.string.croquetas)));
        listComida.add(new Comida(R.drawable.ensalada, getResources().getString(R.string.ensalada)));
        listComida.add(new Comida(R.drawable.hamburguesa, getResources().getString(R.string.hamburguesa)));
        listComida.add(new Comida(R.drawable.menestra, getResources().getString(R.string.menestra)));
        listComida.add(new Comida(R.drawable.paella, getResources().getString(R.string.paella)));
        listComida.add(new Comida(R.drawable.pollo, getResources().getString(R.string.pollo)));
        listComida.add(new Comida(R.drawable.sopas, getResources().getString(R.string.sopas)));
        listComida.add(new Comida(R.drawable.verduras, getResources().getString(R.string.verduras)));

        recycler.setAdapter(new AdaptadorComida(listComida));

    }
}