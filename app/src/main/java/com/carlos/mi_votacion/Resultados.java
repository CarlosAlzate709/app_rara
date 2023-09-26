package com.carlos.mi_votacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    String nombreRecibido, cedulaRecibida, fechaRecibida, votoRecibido;

    TextView TextNombre, TextCedula, TextFecha, TextVoto;

    Button Confirmo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Intent intent =getIntent();
        nombreRecibido = intent.getStringExtra("nombre");
        cedulaRecibida = intent.getStringExtra("cedula");
        fechaRecibida = intent.getStringExtra("fecha");
        votoRecibido = intent.getStringExtra("voto");

        TextNombre = findViewById(R.id.TextViewNombre);
        TextNombre.setText(nombreRecibido.toString());
        TextCedula = findViewById(R.id.TextViewCedula);
        TextCedula.setText(cedulaRecibida.toString());
        TextFecha = findViewById(R.id.TextViewFechaNacimiento);
        TextFecha.setText(fechaRecibida.toString());
        TextVoto = findViewById(R.id.TextViewVoto);
        TextVoto.setText(votoRecibido.toString());

        Confirmo = findViewById(R.id.botonConfirmar);

        Confirmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmar = new Intent(Resultados.this, SplashActivity.class);
                startActivity(confirmar);
            }
        });
    }
}