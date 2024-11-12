package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorComida extends RecyclerView.Adapter<AdaptadorComida.ViewHolder>
{
    private ArrayList<Comida> arrayList;
    public AdaptadorComida(ArrayList<Comida> listComida)
    {
        this.arrayList = listComida;
    }
    @NonNull
    @Override

    public AdaptadorComida.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorComida.ViewHolder holder, int position)
    {
        holder.asignarDatos(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void asignarDatos(Comida comida)
        {
            textView.setText(comida.getNombre());
            imageView.setImageResource(comida.getImagen());
        }
    }
}
