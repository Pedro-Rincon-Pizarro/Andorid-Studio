package com.example.poliglota;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                ArrayList itemSelec = new ArrayList();

                dialogo.setTitle("Idiomas querida");
                dialogo.setMultiChoiceItems(R.array.idiomas, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if(isChecked)
                        {
                            itemSelec.add(getResources().getStringArray(R.array.idiomas)[i]);
                            Toast.makeText(getApplicationContext(), "Nª de checks seleccionados: " + itemSelec.size(), Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            itemSelec.remove(getResources().getStringArray(R.array.idiomas)[i]);
                            Toast.makeText(getApplicationContext(), "Nª de checks seleccionados: " + itemSelec.size(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mensaje = "";
                        for(Object texto : itemSelec)
                        {
                            mensaje += "Idiomas: " + texto;
                        }
                        Toast.makeText(getApplicationContext(), "Nª de checks seleccionados: " + mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo.show();
            }
        });
    }
}