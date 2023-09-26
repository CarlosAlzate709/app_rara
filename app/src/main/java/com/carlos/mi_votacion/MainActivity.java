package com.carlos.mi_votacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String cedula;
    String nombre;
    String fecha;
    String voto;

    Button VotoA, VotoB, VotoC, Enviar;

    EditText Editnombre, Editcedula, Editfecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Editnombre = findViewById(R.id.editTextNombre);

        Editcedula = findViewById(R.id.editTextCedula);

        Editfecha = findViewById(R.id.editTextFechaNacimiento);

        VotoA = findViewById(R.id.botonA);

        VotoA.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View v){
               voto = "A";
           }
        });

        VotoB = findViewById(R.id.botonB);

        VotoB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                voto = "B";
            }
        });

        VotoC = findViewById(R.id.botonC);

        VotoC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                voto = "C";
            }
        });

        Enviar = findViewById(R.id.botonEnviar);

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre = Editnombre.getText().toString();
                cedula = Editcedula.getText().toString();
                fecha = Editfecha.getText().toString();

                if(nombre.isEmpty() && cedula.isEmpty() && fecha.isEmpty() && voto.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Campos Faltantes", Toast.LENGTH_SHORT).show();
                }else{

                    Intent enviarDatos = new Intent(MainActivity.this, Resultados.class);

                    enviarDatos.putExtra("nombre", nombre);
                    enviarDatos.putExtra("cedula", cedula);
                    enviarDatos.putExtra("fecha", fecha);
                    enviarDatos.putExtra("voto", voto);
                    startActivity(enviarDatos);
                }
            }
        });


    }

}