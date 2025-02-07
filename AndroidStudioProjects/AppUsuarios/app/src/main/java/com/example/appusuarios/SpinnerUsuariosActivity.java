package com.example.appusuarios;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appusuarios.conexion.ConexionSQLite;
import com.example.appusuarios.dao.UsuarioDao;
import com.example.appusuarios.modelo.Usuario;

import java.util.ArrayList;

public class SpinnerUsuariosActivity extends AppCompatActivity {

    UsuarioDao usuarioDao;
    Spinner sp;
    ArrayList<Usuario> listaUsuarios;
    ArrayList<String> listaSpinner;
    TextView lblDni, lblNombre, lblTlf;
    ConexionSQLite conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_usuarios);


        usuarioDao = new UsuarioDao();
        conexion = new ConexionSQLite(getApplicationContext(), "bdUsuarios", null, 1);
        sp = findViewById(R.id.spinner);

        lblDni = findViewById(R.id.txtDniLista);
        lblNombre = findViewById(R.id.txtNombreLista);
        lblTlf = findViewById(R.id.txtTlfLista);

        usuarioDao.consultarTodosUsuarios(SpinnerUsuariosActivity.this,listaSpinner, listaUsuarios);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position > 0)
                {
                    Usuario usuario = listaUsuarios.get(position - 1);
                    lblDni.setText(usuario.getDNI());
                    lblNombre.setText(usuario.getNombre());
                    lblTlf.setText(usuario.getTelefono());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }




}