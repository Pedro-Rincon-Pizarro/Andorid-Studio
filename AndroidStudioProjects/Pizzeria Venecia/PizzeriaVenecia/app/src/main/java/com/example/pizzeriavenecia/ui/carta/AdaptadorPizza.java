package com.example.pizzeriavenecia.ui.carta;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeriavenecia.R;
import com.example.pizzeriavenecia.ui.carta.Pizza;

import java.io.Serializable;
import java.util.ArrayList;

public class AdaptadorPizza extends RecyclerView.Adapter <AdaptadorPizza.ViewHolder>{

    private ArrayList<Pizza> listaPizzas;

    public AdaptadorPizza(ArrayList<Pizza> listaPizzas) {
        this.listaPizzas = listaPizzas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPizza.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.asignarDatos(listaPizzas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pizzaSeleccionada", listaPizzas.get(position));

                Navigation.findNavController(view).navigate(R.id.action_nav_gallery_to_nav_pizza,bundle);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listaPizzas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            textView = itemView.findViewById(R.id.textView3);
        }

        public void asignarDatos(Pizza pizza) {
            imageView.setImageResource(pizza.getImagen());
            textView.setText(pizza.getNombre());
        }
    }
}