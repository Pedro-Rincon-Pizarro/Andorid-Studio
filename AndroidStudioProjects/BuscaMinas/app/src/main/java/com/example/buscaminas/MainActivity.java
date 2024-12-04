package com.example.buscaminas;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Bomba> arrayBombas = new ArrayList<Bomba>();
    String dificultad = "";
    GridLayout grid;
    Button button;
    int[][] valoresBombas;
    Spinner spinner;
    int icono;
    MediaPlayer pum, pedo, win;
    int marcadas = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.grid);
        pum = MediaPlayer.create(this, R.raw.pum);
        pedo = MediaPlayer.create(this, R.raw.pedo);
        win = MediaPlayer.create(this, R.raw.win);
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
                grid.removeAllViewsInLayout();
                grid.setRowCount(8);
                grid.setColumnCount(8);

                ajustarGrid(10);
                generarBombas(10);
            }
            else if(dificultad.equals("Amateur"))
            {
                grid.removeAllViewsInLayout();
                grid.setRowCount(12);
                grid.setColumnCount(12);

                ajustarGrid(30);
                generarBombas(30);
            }
            else if(dificultad.equals("Avanzada"))
            {
                grid.removeAllViewsInLayout();
                grid.setRowCount(16);
                grid.setColumnCount(16);

                ajustarGrid(60);
                generarBombas(60);
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


            spinner = new Spinner(this);

            MiAdaptador adaptador = new MiAdaptador(this, R.layout.layout_item, arrayBombas);
            spinner.setAdapter(adaptador);

            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setTitle("Selecciona una opcion");
            dialogo.setView(spinner);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    item.setIcon(arrayBombas.get(position).getImagen());
                    icono = arrayBombas.get(position).getImagen();
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
        int f = 0;
        int c = 0;
        valoresBombas = new int[grid.getRowCount()][grid.getColumnCount()];
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

    public void ajustarGrid(int numBomb)
    {
        marcadas = 0;
        grid.removeAllViews();

        int numFilas = grid.getRowCount();
        int numColumnas = grid.getColumnCount();

        for (int fila = 0; fila < grid.getRowCount(); fila++)
        {
            for(int columna = 0; columna < grid.getColumnCount(); columna++)
            {
                button = new Button(this);
                button.setTextColor(Color.parseColor("black"));
                button.setId(grid.getColumnCount() * fila + columna);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec =  GridLayout.spec(fila);
                params.columnSpec = GridLayout.spec(columna);
                params.width = grid.getWidth() / numColumnas;
                params.height = grid.getHeight() / numFilas;


                grid.addView(button,params);
                button.setOnLongClickListener(new View.OnLongClickListener()
                {
                    @Override
                    public boolean onLongClick(View view) {
                        int row = view.getId() % grid.getColumnCount();
                        int colum = (view.getId() - row) / grid.getColumnCount();

                        if (valoresBombas[row][colum] == -1) {
                            view.setBackgroundColor(Color.parseColor("yellow"));
                            view.setBackgroundResource(R.drawable.banderin);// Marca como sospechosa con color naranja.
                            Toast.makeText(MainActivity.this, "Marcado como bomba", Toast.LENGTH_SHORT).show();
                            marcadas++;
                            if(marcadas == numBomb)
                            {
                                AlertDialog.Builder dlgInstrucciones = new AlertDialog.Builder(MainActivity.this);
                                dlgInstrucciones.setTitle("Has Ganado");
                                dlgInstrucciones.setMessage("Has marcado todas las bombas!!");
                                dlgInstrucciones.setIcon(icono);
                                win.start();
                                dlgInstrucciones.setPositiveButton("Ok", (dialogInterface, i) -> {
                                    dialogInterface.dismiss();
                                    grid.removeAllViews();
                                });
                                dlgInstrucciones.create().show();
                            }
                        } else
                        {
                            AlertDialog.Builder dlgInstrucciones = new AlertDialog.Builder(MainActivity.this);
                            dlgInstrucciones.setTitle("Has perdido");
                            dlgInstrucciones.setMessage("No habia ninguna bomba");
                            dlgInstrucciones.setIcon(icono);
                            pedo.start();
                            dlgInstrucciones.setPositiveButton("Ok", (dialogInterface, i) -> {
                                dialogInterface.dismiss();
                                grid.removeAllViews();
                            });
                            dlgInstrucciones.create().show();
                        }
                        return true; // Retorna true para indicar que se manejó el evento de clic largo.
                    }
                });

                button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        int a = view.getId() % grid.getColumnCount();
                        int b = (view.getId() - a) / grid.getColumnCount();
                        if(valoresBombas[a][b] == -1)
                        {
                            view.setBackgroundColor(Color.parseColor("red"));
                            view.setBackgroundResource(icono);
                            AlertDialog.Builder dlgInstrucciones = new AlertDialog.Builder(MainActivity.this);
                            dlgInstrucciones.setTitle("Has perdido");
                            dlgInstrucciones.setMessage("La bomba ha explotado!!!!");
                            pum.start();
                            dlgInstrucciones.setIcon(icono);
                            dlgInstrucciones.setPositiveButton("Ok", (dialogInterface, i) -> {
                                dialogInterface.dismiss();
                                grid.removeAllViews();
                            });
                            dlgInstrucciones.create().show();


                        }
                        else
                        {
                            int bombascircundantes = comprobarBotonesCircundantes(a, b);
                            if(bombascircundantes == 0)
                            {
                                revelarBotonesCircundantes(a, b);
                            }
                            else
                            {
                                view.setBackgroundColor(Color.parseColor("green"));
                                ((Button) view).setText(String.valueOf(bombascircundantes));
                            }
                        }
                    }
                });
            }
        }
    }

    public void revelarBotonesCircundantes(int a, int b) {
        for (int i = Math.max(0, a - 1); i <= Math.min(valoresBombas.length - 1, a + 1); i++)
        {
            for (int j = Math.max(0, b - 1); j <= Math.min(valoresBombas[0].length - 1, b + 1); j++)
            {
                Button boton = (Button) grid.getChildAt(j * grid.getColumnCount() + i); // Obtener el botón en esa posición.

                if (boton != null && boton.isEnabled()) { // Verifica que el botón no haya sido revelado ya.
                    boton.setEnabled(false); // Desactiva el botón para evitar loops.
                    int bombascircundantes = comprobarBotonesCircundantes(i, j);

                    if (bombascircundantes == 0)
                    {
                        boton.setBackgroundColor(Color.parseColor("green"));
                        revelarBotonesCircundantes(i, j); // Llamada recursiva.
                    } else
                    {
                        boton.setBackgroundColor(Color.parseColor("green"));
                        boton.setText(String.valueOf(bombascircundantes));
                    }
                }
            }
        }
    }


    public int comprobarBotonesCircundantes(int a, int b)
    {
        int bombasCerca = 0;
        for (int i = Math.max(0, a - 1); i <= Math.min(valoresBombas.length - 1, a + 1); i++)
        {
            for (int j = Math.max(0, b - 1); j <= Math.min(valoresBombas[0].length - 1, b + 1); j++)
            {
                if (valoresBombas[i][j] == -1)
                {
                    bombasCerca++;
                }
            }
        }
        return bombasCerca;

    }
}
