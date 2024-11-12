package com.example.a1listas_pedrorincon;

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

public class MiAdaptador extends ArrayAdapter<Animal> {
    Context contexto;
    int layout;
    List<Animal> arrayAnim;
    //constructor
    public MiAdaptador(@NonNull Context context, int resource, @NonNull List<Animal> objects) {
        super(context, resource, objects);
        contexto = context;
        layout = resource;
        arrayAnim =(List<Animal>) objects;
    }

    @NonNull
    @Override
    //metodo getView que carga una vista con la informacion referida a cada item
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(layout, parent, false);
        ImageView img = view.findViewById(R.id.imageView2);
        TextView texto = view.findViewById(R.id.textView2);

        Animal a = arrayAnim.get(position);
        texto.setText(a.getNombre());
        img.setImageResource(a.getImagen());

        return view;
    }
}
