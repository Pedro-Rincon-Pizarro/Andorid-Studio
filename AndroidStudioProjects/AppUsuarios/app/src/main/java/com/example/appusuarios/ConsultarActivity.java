package com.example.appusuarios;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import com.example.appusuarios.conexion.ConexionSQLite;
import com.example.appusuarios.dao.UsuarioDao;
import com.example.appusuarios.modelo.Usuario;
import com.example.appusuarios.utilidades.Utilidades;

public class ConsultarActivity extends AppCompatActivity {

    EditText txtDni, txtNombre, txtTlf;
    Button btBuscar, btActualizar, btLimpiar, btBorrar;
    ConexionSQLite conexion;
    UsuarioDao uDao = new UsuarioDao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consultar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtDni = findViewById(R.id.txtDni);
        txtNombre = findViewById(R.id.txtNombre);
        txtTlf = findViewById(R.id.txtTlf);

        conexion = new ConexionSQLite(getApplicationContext(), "bdUsuarios", null, 1);
        btBuscar = findViewById(R.id.btBuscar);
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    Usuario u = uDao.consultarUsuario(ConsultarActivity.this,txtDni.getText().toString());
                    txtNombre.setText(u.getNombre());
                    txtTlf.setText(u.getTelefono());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        btActualizar = findViewById(R.id.btActualizar);

        btActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u = new Usuario(txtDni.getText().toString(),txtNombre.getText().toString(),txtTlf.getText().toString());
                int filas = uDao.actualizarUsuario(ConsultarActivity.this, u);
                if(filas > 0)
                {
                    Toast.makeText(ConsultarActivity.this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ConsultarActivity.this, "Error", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btLimpiar = findViewById(R.id.btLimpiar);

        btLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDni.setText("");
                txtNombre.setText("");
                txtTlf.setText("");
            }
        });
        btBorrar = findViewById(R.id.btBorrar);

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int filas = uDao.eliminarUsuario(ConsultarActivity.this, txtDni.getText().toString());

                if(filas > 0)
                {
                    Toast.makeText(ConsultarActivity.this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ConsultarActivity.this, "Error", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}