package com.example.buscaminas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Bomba> arrayBombas = new ArrayList<Bomba>();
    String dificultad = "";
    GridLayout grid;
    Button button;
    int j = 0;
    Integer[][] valoresBombas;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.grid);

        arrayBombas.add(new Bomba(R.drawable.bomba, getResources().getString(R.string.bomba1)));
        arrayBombas.add(new Bomba(R.drawable.bomba1, getResources().getString(R.string.bomba2)));
        arrayBombas.add(new Bomba(R.drawable.coctel, getResources().getString(R.string.bomba3)));
        arrayBombas.add(new Bomba(R.drawable.explosivos, getResources().getString(R.string.bomba4)));
        arrayBombas.add(new Bomba(R.drawable.granada, getResources().getString(R.string.bomba5)));
        arrayBombas.add(new Bomba(R.drawable.mina, getResources().getString(R.string.bomba6)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.intrucciones)
        {
            AlertDialog.Builder dlgInstrucciones = new AlertDialog.Builder(MainActivity.this);
            dlgInstrucciones.setTitle("Instrucciones");
            dlgInstrucciones.setMessage("Cuando pulsas en una casilla, sale un numero que identifica cuantas minas hay alrededor. Ten cuidado porque si pulsas " +
                    "en una casilla que tenga una mina escondida, perderas. Si crees o tienes certeza de que hay una mina, haz un click largo " +
                    "sobre la casilla para señalarla. No hagas un click largo en una casilla donde no hay una mina porqe perderas. Ganas una vez " +
                    "hayas encontrado todas las minas.");
            dlgInstrucciones.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss());
            dlgInstrucciones.create().show();
        }
        else if(item.getItemId() == R.id.comenzar)
        {
            if(dificultad.equals("") || dificultad.equals("Principiante"))
            {
                grid.setRowCount(8);
                grid.setColumnCount(8);
                valoresBombas = new Integer[8][8];
                //generarBombas(10);
                ajustarGrid();
            }
            else if(dificultad.equals("Amateur"))
            {
                grid.setRowCount(12);
                grid.setColumnCount(12);
                valoresBombas = new Integer[12][12];
                //generarBombas(30);
                ajustarGrid();
            }
            else if(dificultad.equals("Avanzada"))
            {
                grid.setRowCount(16);
                grid.setColumnCount(16);
                valoresBombas = new Integer[16][16];
                //generarBombas(60);
                ajustarGrid();
            }
        }
        else if(item.getItemId() == R.id.configurar)
        {
            AlertDialog.Builder dlgDificultad = new AlertDialog.Builder(this);

            dlgDificultad.setTitle("Dificultad a elegir");
            dlgDificultad.setSingleChoiceItems(R.array.dificultad, -1, (dialogInterface, i) -> dificultad = getResources().getStringArray(R.array.dificultad)[i]);

            dlgDificultad.setPositiveButton("Volver", (dialogInterface, i) -> {
                if (dificultad != null && !dificultad.isEmpty()) {
                    Toast.makeText(MainActivity.this, dificultad, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "No seleccionaste ningún elemento", Toast.LENGTH_SHORT).show();
                }
            });

            dlgDificultad.show();
        }

        else if(item.getItemId() == R.id.bomba)
        {


            Spinner spinner = new Spinner(this);

            MiAdaptador adaptador = new MiAdaptador(this, R.layout.layout_item, arrayBombas);
            spinner.setAdapter(adaptador);

            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setTitle("Selecciona una opcion");
            dialogo.setView(spinner);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    item.setIcon(arrayBombas.get(position).getImagen());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            dialogo.setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialogo.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void generarBombas(int numeroBombas)
    {
        Random rd = new Random();
        int f;
        int c;
        for (int i = 0; i < numeroBombas; i++)
        {
            do
            {
                f = rd.nextInt(grid.getRowCount());
                c = rd.nextInt(grid.getColumnCount());
            }while(valoresBombas[f][c] == -1);

            valoresBombas[f][c] = -1;
        }
    }

    public void ajustarGrid()
    {
        grid.removeAllViews();
        int numFilas = grid.getRowCount();
        int numColumnas = grid.getColumnCount();

        for (int fila = 0; fila < grid.getRowCount(); fila++)
        {
            for(int columna = 0; columna < grid.getColumnCount(); columna++)
            {
                button = new Button(this);

                button.setId(ViewGroup.generateViewId());
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec =  GridLayout.spec(fila);
                params.columnSpec = GridLayout.spec(columna);
                params.width = grid.getWidth() / numColumnas;
                params.height = grid.getHeight() / numFilas;
                int f = fila;
                int c = columna;

                grid.addView(button,params);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        if(valoresBombas[f][c] == -1)
                        {
                            button.setBackgroundColor(Color.parseColor("red"));
                        }
                        else {
                            button.setBackgroundColor(Color.parseColor("green"));
                        }
                    }
                });
            }
        }
    }
}