package com.example.appusuarios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appusuarios.dao.UsuarioDao;
import com.example.appusuarios.modelo.Usuario;

public class RegistroActivity extends AppCompatActivity {

    EditText dni, nombre, tlf;
    Button btRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dni = findViewById(R.id.txtDni);
        nombre = findViewById(R.id.txtNombre);
        tlf = findViewById(R.id.txtTlf);
        btRegistrar = findViewById(R.id.btRegis);

        UsuarioDao usuarioDao = new UsuarioDao();

        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.setDNI(dni.getText().toString());
                usuario.setNombre(nombre.getText().toString());
                usuario.setTelefono(tlf.getText().toString());

                long identificador = usuarioDao.insertarUsuario(RegistroActivity.this,usuario);

                if(identificador != -1)
                {
                    Toast.makeText(RegistroActivity.this, "Se ha insertado con exito", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RegistroActivity.this, "No se ha podido registrar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}