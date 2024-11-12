package com.example.listviewsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<String> array = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list =findViewById(R.id.list);
        array.add("Susana");
        array.add("Francisco");
        array.add("Ruben");
        array.add("Marta");
        array.add("Maria");
        array.add("Fernando");
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, array);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(), "Nombre seleccionado: " + list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}