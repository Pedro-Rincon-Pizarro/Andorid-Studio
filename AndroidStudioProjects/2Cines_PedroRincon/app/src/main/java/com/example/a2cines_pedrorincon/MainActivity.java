package com.example.a2cines_pedrorincon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView eleccion, txtCine;
    ImageView img;
    RadioButton btCinema, btCinepolis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enlace de widgets a su id
        eleccion = findViewById(R.id.eleccion);
        btCinema = findViewById(R.id.btCinema);
        btCinepolis = findViewById(R.id.btCinepolis);
        txtCine = findViewById(R.id.txtCine);
        img = findViewById(R.id.imgCine);

        //escuchador de Cinema que cambia la imagen y el texto cuando lo pulsa
        btCinema.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    txtCine.setText(btCinema.getText());
                    img.setImageResource(R.drawable.cinema);
                }
            }
        });

        //escuchador de Cinepolis que cambia la imagen y el texto cuando lo pulsa
        btCinepolis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                    txtCine.setText(btCinepolis.getText());
                    img.setImageResource(R.drawable.cinepolis);
                }
            }
        });

    }



    @Override
    //creador de opciones del menu que infla con el menú que hemos creado en la carpeta menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    //escuchador que detecta cuando una opcion del menú es  seleccionada
    //dependiendo del boton muestra un toast o un dialogo
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.precios)
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Tarifa de precios");
            dialog.setMessage("Precio normal: 10€\n" +
                               "Precio joven: 6€\n" +
                                "Jubilados: 5€\n");
            dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            dialog.create().show();
        }
        else if (item.getItemId() == R.id.peliculas)
        {
            Toast.makeText(this, "Has seleccionado Peliculas", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.buscar)
        {
            Toast.makeText(this, "Has seleccionado Buscar", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }





}