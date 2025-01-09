package com.example.sharemybike;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BikeContent
{
    public static final List<Bike> ITEMS = new ArrayList<>();

    public static void inicializarDatos(Context context)
    {
        if (ITEMS.isEmpty()) {
            ITEMS.add(new Bike(R.drawable.bike1, "Nice bike, 27' wheels", "Via Flippo Carcano, 26", "Francesco Lombardi", "Milan"));
            ITEMS.add(new Bike(R.drawable.bike2, "Always garaged, never dropped", "Avenida de Francisco Aguirre, 22", "Hipolito de Castro", "Talavera"));
            ITEMS.add(new Bike(R.drawable.bike3, "Sturdy bike, perfect for mountains", "Eickenerstrasse 227", "Hans Gunter Egelhoff", "Monchenglandbach"));
            ITEMS.add(new Bike(R.drawable.bike4, "Small bike for long rides", "Chemin du Convent, 176", "Antony Schooling", "Lyon"));
            ITEMS.add(new Bike(R.drawable.bike5, "Have comon craigh with a reliable hink", "Bisshops town, 22ac", "Geral Brennan", "Cork"));
        }
    }

}
