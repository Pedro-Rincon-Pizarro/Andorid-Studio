package com.example.listapersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Ciudad> arrayList = new ArrayList<Ciudad>();
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        arrayList.add(new Ciudad(getResources().getString(R.string.Burgos),getResources().getString(R.string.descBurgos), R.drawable.catedral));
        arrayList.add(new Ciudad(getResources().getString(R.string.Segovia),getResources().getString(R.string.descSegovia), R.drawable.acueducto));
        arrayList.add(new Ciudad(getResources().getString(R.string.Salamanca),getResources().getString(R.string.descSalamanca), R.drawable.conchas));
        arrayList.add(new Ciudad(getResources().getString(R.string.Avila),getResources().getString(R.string.descAvila), R.drawable.murallas));
        arrayList.add(new Ciudad(getResources().getString(R.string.Valladolid),getResources().getString(R.string.descValladolid), R.drawable.sanpablo));

        MiAdaptadorCiudad adapt = new MiAdaptadorCiudad(this, R.layout.item_ciudad, arrayList);
        lista.setAdapter(adapt);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //toast
            }
        });
    }
}