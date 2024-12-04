package com.example.intentimplicito2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PHONE = 1;
    Button btLlamada, btEmail, btMapa, btPag;
    EditText txtLlamada, txtEmail, txtLat, txtLong, txtPag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLlamada = findViewById(R.id.btLlamar);
        txtLlamada = findViewById(R.id.txtTlf);

        btLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCallPermission(txtLlamada.getText().toString());
            }
        });
    }

    private void checkCallPermission(String telefono) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            hacerUnLLamado(telefono);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                hacerUnLLamado(txtLlamada.getText().toString());
            } else {
                Toast.makeText(this, "Permiso de llamada denegado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void hacerUnLLamado(String telefono) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(telefono));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}