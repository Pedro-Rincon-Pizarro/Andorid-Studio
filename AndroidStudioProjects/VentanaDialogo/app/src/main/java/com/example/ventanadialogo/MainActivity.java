package com.example.ventanadialogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonDialog, botonLista, btDate;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        botonDialog = findViewById(R.id.button);
        botonLista = findViewById(R.id.button2);
        btDate = findViewById(R.id.btDate);

        botonDialog.setOnClickListener(this);
        botonLista.setOnClickListener(this);
        btDate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {

        if(view.getId() == R.id.button)
        {
            dialogoAlert();
        }
        else if (view.getId() == R.id.button2)
        {
            dialogoLista();
        }
        else if(view.getId() == R.id.btDate)
        {
            dialogoFecha();
        }
    }
    private void dialogoAlert()
    {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setMessage("¿Empezar el juego?");
        dialogo.setTitle("Bienvenido");
        dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(MainActivity.this, "Empieza el Juego", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(MainActivity.this, "Saliendo del juego", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        dialogo.create().show();
    }

    private void dialogoLista()
    {
        final String [] nav = getResources().getStringArray(R.array.lista_nav);
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Elige un Navegador");
        dialogo.setItems(nav, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(MainActivity.this,"Navegador seleccionado: " + nav[i], Toast.LENGTH_SHORT).show();
            }
        });
        dialogo.create().show();
    }

    private void dialogoFecha()
    {
        Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpdDate = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                String texto = String.valueOf(dia + "/" + (mes+1) + "/" + anio);
                Toast.makeText(MainActivity.this,"Fecha actual: " + texto, Toast.LENGTH_SHORT).show();
            }
        },anio, mes, dia);
        dpdDate.show();
    }
}