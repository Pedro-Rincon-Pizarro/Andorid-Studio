package com.example.intentexplicito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class intentExplicito2 extends AppCompatActivity {

    String nombre, mensaje;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_explicito2);

        textView = findViewById(R.id.textoFinal);
        Intent intento = getIntent();
        nombre = intento.getStringExtra("nombre");
        mensaje = String.format(getResources().getString(R.string.bienvenido), nombre);
        textView.setText(mensaje);
    }
}