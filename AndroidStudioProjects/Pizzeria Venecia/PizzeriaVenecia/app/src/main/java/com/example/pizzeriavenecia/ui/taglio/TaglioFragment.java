package com.example.pizzeriavenecia.ui.taglio;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pizzeriavenecia.databinding.FragmentTaglioBinding;

public class TaglioFragment extends Fragment {

private FragmentTaglioBinding binding;
private String tipo1, tipo2, fecha, hora, nombre;
private boolean tip1 = false, swActivado = false, fech = false, hor = false, nomb = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        TaglioViewModel taglioViewModel = new ViewModelProvider(this).get(TaglioViewModel.class);

    binding = FragmentTaglioBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        binding.spinner2.setVisibility(View.INVISIBLE);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.swmitades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(binding.spinner2.getVisibility() == View.INVISIBLE)
                {
                    binding.spinner2.setVisibility(View.VISIBLE);

                }
                else if(binding.spinner2.getVisibility() == View.VISIBLE)
                {
                    binding.spinner2.setVisibility(View.INVISIBLE);
                    swActivado = false;

                }
            }
        });



        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tipo1 = binding.spinner.getSelectedItem().toString();
                tip1 = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tipo2 = binding.spinner2.getSelectedItem().toString();
                swActivado = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.calendarView2.setOnDateChangeListener((calendarView, dayOfMonth, month, year) -> {
            String selectedDate = year + "/" + (month + 1) + "/" + dayOfMonth;

            // Mostrar un mensaje con la fecha seleccionada
            fecha = selectedDate;
            fech = true;


        });

        binding.spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hora = binding.spinner3.getSelectedItem().toString();
                hor = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        binding.btPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = binding.editTextText.getText().toString();
                nomb = true;
                String tipo2Temp = "";
                if(swActivado == true)
                {
                    tipo2Temp = "Segundo sabor: " + tipo2;
                }
                if(tip1 == true && swActivado == true && fech == true && hor == true && nomb == true)
                {
                    Toast.makeText(getContext(), "creando pedido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // Asegúrate de usar "mailto:" como esquema
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pizeriavenecia@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido taglio " + fecha + " " + hora);
                    intent.putExtra(Intent.EXTRA_TEXT, "Tipo de Pizza: " + tipo1 + "\n" +
                                    tipo2Temp + "\n" +
                                    "Fecha: " + fecha + "\n" +
                                    "Hora: " + hora + "\n" +
                                    "Nombre: " + nombre );

                    Context context = view.getContext(); // o pasa el contexto al adaptador
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    } else {
                        Toast.makeText(context, "No hay aplicaciones de correo instaladas.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}