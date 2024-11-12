package com.example.listapersonalizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptadorCiudad extends ArrayAdapter<Ciudad> {
    private Context contexto;
    private int item;
    private List<Ciudad> listaCiudades;

    public MiAdaptadorCiudad(@NonNull Context context, int resource, @NonNull List<Ciudad> objects) {
        super(context, resource, objects);
        contexto = context;
        item = resource;
        listaCiudades = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(item, parent, false);
        TextView textoNombre = view.findViewById(R.id.textView2);
        TextView textoDesc = view.findViewById(R.id.textView1);
        ImageView imagen = view.findViewById(R.id.imageView2);

        Ciudad elementoCiudad = listaCiudades.get(position);
        textoNombre.setText(elementoCiudad.getNombre());
        textoDesc.setText(elementoCiudad.getDescripcion());
        imagen.setImageResource(elementoCiudad.getImagen());
        return view;
    }
}
