package com.example.a1listas_pedrorincon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Animal> arrayAnimales = new ArrayList<Animal>();
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enlazar la lista con el xml, cargar el array con objetos, crear un adaptador y setear el adaptador a la lista
        lista = findViewById(R.id.idLista);
        arrayAnimales.add(new Animal(getResources().getString(R.string.caballo), R.drawable.caballo));
        arrayAnimales.add(new Animal(getResources().getString(R.string.gato), R.drawable.gato));
        arrayAnimales.add(new Animal(getResources().getString(R.string.leon), R.drawable.leon));
        arrayAnimales.add(new Animal(getResources().getString(R.string.mono), R.drawable.mono));
        arrayAnimales.add(new Animal(getResources().getString(R.string.oso), R.drawable.oso));
        arrayAnimales.add(new Animal(getResources().getString(R.string.vaca), R.drawable.vaca));
        arrayAnimales.add(new Animal(getResources().getString(R.string.zorro), R.drawable.zorro));
        MiAdaptador adaptador = new MiAdaptador(this,R.layout.layout_animal,arrayAnimales);
        lista.setAdapter(adaptador);

        //escuchador de la lista que escribe el nombre del animal elegido en un toast
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = adaptador.getItem(position).getNombre();
                Toast.makeText(MainActivity.this, "Animal elegido: " + texto, Toast.LENGTH_SHORT).show();
            }
        });

    }


}