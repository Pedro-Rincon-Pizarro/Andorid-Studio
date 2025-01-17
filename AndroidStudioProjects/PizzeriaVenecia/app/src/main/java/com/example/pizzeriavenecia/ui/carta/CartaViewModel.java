package com.example.pizzeriavenecia.ui.carta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pizzeriavenecia.R;

import java.util.ArrayList;

public class CartaViewModel extends ViewModel {

    private final ArrayList<Pizza> listaPizzas = new ArrayList<>();

    public CartaViewModel() {

        listaPizzas.add(new Pizza("Rabo de Toro", "Salsa demi-glace, rabo de toro estofado y queso mozzarella.", R.drawable.rabotoro, "M 16,50 € - F 34,00 €"));
        listaPizzas.add(new Pizza("Antojo de Otoño", "Crema de boletus, queso mozzarella fior di latte, champiñones frescos, boletus, jamón ibérico y aceite verde.", R.drawable.antojo, "M 16,50 € - F 34,00 €"));
        listaPizzas.add(new Pizza("Costilla", "Base de tomate ecológico, mozzarella fior di latte, carne de costilla de cerdo especiada y cocinada a baja temperatura, queso flor de Esgueva y salsa de barbacoa ahumada. ", R.drawable.costilla, "M 15,50 € - F 32,00 €"));
        listaPizzas.add(new Pizza("De la Huerta", "Salsa demi-glace, rabo de toro estofado y queso mozzarella.", R.drawable.huerta, "M 14,00 € - F 29,00 €"));
        listaPizzas.add(new Pizza("Cecina", "Base de tomate ecológico, mozzarella fior di latte, cecina León y queso de Flor de Esgueva.", R.drawable.cecina, "M 14,00 € - F 29,00 €"));
        listaPizzas.add(new Pizza("Iberica", "Tomate ecológico, mozzarella fior di latte y jamón ibérico. ", R.drawable.iberica, "M 14,00 € - F 29,00 €"));
        listaPizzas.add(new Pizza("Popeye", "Crema de espinacas, mozzarella fior di latte, Flor de Esgueva y bacon. ", R.drawable.popeye, "M 13,00 € - F 27,00 €"));
        listaPizzas.add(new Pizza("Mexicana", "Tomate picante del chef, mozzarella fior di latte, carne de ternera con chimichurri, pepperoni y jalapeños.  ", R.drawable.placeholder, "M 14,00 € - F 29,00 €"));
        listaPizzas.add(new Pizza("7 Quesos", "Base de tomate ecológico, mozzarella fior di latte, Grana Padano, Flor de Esgueva, gorgonzola, emmenthal, gouda y queso de cabra.  ", R.drawable.placeholder, "M 14,00 € - F 29,00 €"));
        listaPizzas.add(new Pizza("La de Javi", "Base de tomate ecológico, mozzarella fior di latte, jamón york, bacon, champiñones frescos y extra de queso. ", R.drawable.placeholder, "M 13,00 € - F 27,00 €"));

    }

    public ArrayList<Pizza> getListaPizzas() {
        return listaPizzas;
    }
}