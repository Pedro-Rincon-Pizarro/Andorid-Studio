package com.example.buscaminas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MiAdaptador extends ArrayAdapter<Bomba>
{

    Context contexto;
    int layout;
    List<Bomba> objetos;
    public MiAdaptador(@NonNull Context context, int resource, @NonNull List<Bomba> objects) {
        super(context, resource, objects);
        contexto = context;
        layout = resource;
        objetos = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = cargarVista(position, parent);

        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = cargarVista(position, parent);

        return view;
    }

    private @NonNull View cargarVista(int position, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.layout_item, parent, false);
        TextView txtNombre = (TextView) view.findViewById(R.id.textoBomba);

        ImageView img = (ImageView) view.findViewById(R.id.imagenBomba);
        Bomba bomba = objetos.get(position);
        txtNombre.setText(bomba.getNombre());
        img.setImageResource(bomba.getImagen());
        return view;
    }


}
