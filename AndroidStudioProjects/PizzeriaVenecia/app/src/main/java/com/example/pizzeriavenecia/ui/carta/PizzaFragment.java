package com.example.pizzeriavenecia.ui.carta;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzeriavenecia.R;


public class PizzaFragment extends Fragment {

    private Pizza pizza;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pizza, container, false);

        if(getArguments() != null)
        {
            pizza = (Pizza) getArguments().getSerializable("pizzaSeleccionada");
        }

        ImageView imagenPizza = root.findViewById(R.id.img);
        TextView nombrePizza = root.findViewById(R.id.txtNombre);
        TextView descripcionPizza = root.findViewById(R.id.txtDescripcion);
        TextView precioPizza = root.findViewById(R.id.txtPrecio);

        if(pizza != null)
        {
            imagenPizza.setImageResource(pizza.getImagen());
            nombrePizza.setText(pizza.getNombre());
            descripcionPizza.setText(pizza.getDescripcion());
            precioPizza.setText(pizza.getPrecio());
        }
        return root;
    }
}