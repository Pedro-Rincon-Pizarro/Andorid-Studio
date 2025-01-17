package com.example.pizzeriavenecia.ui.contacto;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.Manifest;


import com.example.pizzeriavenecia.R;
import com.example.pizzeriavenecia.databinding.FragmentContactoBinding;
import com.example.pizzeriavenecia.databinding.FragmentTaglioBinding;
import com.example.pizzeriavenecia.ui.taglio.TaglioViewModel;

public class ContactoFragment extends Fragment {

    private FragmentContactoBinding binding;

    public static ContactoFragment newInstance() {
        return new ContactoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ContactoViewModel contactoViewModel = new ViewModelProvider(this).get(ContactoViewModel.class);
        binding = FragmentContactoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final int REQUEST_CALL_PHONE = 1;

                if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    // Permiso concedido, realizar la llamada
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:947500561"));

                    if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    // Solicitar el permiso de llamada
                    ActivityCompat.requestPermissions(requireActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            REQUEST_CALL_PHONE);
                }
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(Uri.parse("geo:41.668907,-3.689825?q=41.668907,-3.689985(Pizzería+Venecia)"));
            }
        });


    }

    public void showMap(Uri geoLocation)
    {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Si no hay actividad para manejar el intent (por ejemplo, Google Maps no está instalado), puedes mostrar un mensaje o abrir otro mapa
            Toast.makeText(getContext(), "Google Maps no está instalado", Toast.LENGTH_SHORT).show();
        }
    }


}