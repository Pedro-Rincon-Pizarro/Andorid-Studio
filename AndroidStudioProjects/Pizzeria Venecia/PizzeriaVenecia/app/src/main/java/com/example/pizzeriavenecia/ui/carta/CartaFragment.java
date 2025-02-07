package com.example.pizzeriavenecia.ui.carta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeriavenecia.databinding.FragmentCartaBinding;

import java.util.ArrayList;


public class CartaFragment extends Fragment {

private FragmentCartaBinding binding;
private ArrayList<Pizza> listaPizzas;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        CartaViewModel cartaViewModel = new ViewModelProvider(this).get(CartaViewModel.class);

        binding = FragmentCartaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        listaPizzas = cartaViewModel.getListaPizzas();
        recyclerView.setAdapter(new AdaptadorPizza(listaPizzas));
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}