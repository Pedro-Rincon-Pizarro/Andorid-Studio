package com.example.ejerciciodialogo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button boton1, boton2;
    String dificultad;
    Spinner spinner;
    ArrayList<Bomba> arrayBombas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        spinner = findViewById(R.id.spinner);

        arrayBombas.add(new Bomba(getResources().getString(R.string.bomba1), R.drawable.bomba1));
        arrayBombas.add(new Bomba(getResources().getString(R.string.bomba2), R.drawable.bomba));
        arrayBombas.add(new Bomba(getResources().getString(R.string.bomba3), R.drawable.explosivos));
        arrayBombas.add(new Bomba(getResources().getString(R.string.bomba4), R.drawable.granada));
        arrayBombas.add(new Bomba(getResources().getString(R.string.bomba5), R.drawable.mina));
        arrayBombas.add(new Bomba(getResources().getString(R.string.bomba6), R.drawable.coctel));
        MiAdaptadorBomba adapter = new MiAdaptadorBomba(MainActivity.this, R.layout.layout_bombas, arrayBombas);
        spinner.setAdapter(adapter);

        boton1.setOnClickListener(view -> {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
            dialogo.setTitle("Instrucciones");
            dialogo.setMessage("Cuando pulsas en una casilla, sale un numero que identifica" +
                    " cuantas minas hay alrededor.Ten cuidado porque si pulsas en una casilla" +
                    " que tenga una mina escondida, perderas.Si crees o tienes certeza de que" +
                    " hay una mina, haz un click largo sobre la casilla para señalarla.No hagas" +
                    " un click largo en una casilla donde no hay una mina porqe perderas.Ganas una vez hayas encontrado todas las minas.");
            dialogo.setPositiveButton("ok", (dialogInterface, i) -> dialogInterface.dismiss());
            dialogo.create().show();
        });
        boton2.setOnClickListener(view -> {
            AlertDialog.Builder dificultadDialog = new AlertDialog.Builder(MainActivity.this);
            dificultadDialog.setTitle("Dificultad");
            dificultadDialog.setSingleChoiceItems(R.array.array, -1, (dialogInterface, i) -> dificultad = getResources().getStringArray(R.array.array)[i]);
            dificultadDialog.setPositiveButton("Volver", (dialogInterface, i) -> {
                if(dificultad != null)
                {
                    Toast.makeText(MainActivity.this, dificultad, Toast.LENGTH_SHORT).show();
                }
            });
            dificultadDialog.create().show();
        });



    }


}