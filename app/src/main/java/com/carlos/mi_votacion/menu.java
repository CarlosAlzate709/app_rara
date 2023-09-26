package com.carlos.mi_votacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.provider.Settings;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class menu extends AppCompatActivity {

    Button actividad2, google, alarma, llamada, mapa, Wi_fi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        actividad2 = findViewById(R.id.btn_actividad2);
        google = findViewById(R.id.btn_google);
        alarma = findViewById(R.id.btn_alarma);
        llamada = findViewById(R.id.btn_llamar);
        mapa = findViewById(R.id.btn_mapa);
        Wi_fi = findViewById(R.id.btn_wifi);

        actividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actividad_2 = new Intent(menu.this, MainActivity.class);
                startActivity(actividad_2);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irAGoogle = new Intent(Intent.ACTION_VIEW);
                irAGoogle.setData(Uri.parse("https://www.youtube.com/watch?v=V1dGbBGDp1c"));
                startActivity(irAGoogle);
            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarma.putExtra(AlarmClock.EXTRA_MESSAGE, "wake up");
                alarma.putExtra(AlarmClock.EXTRA_HOUR, 19);
                alarma.putExtra(AlarmClock.EXTRA_MINUTES, 36);
                if(alarma.resolveActivity(getPackageManager())!=null){
                    startActivity(alarma);
                }
            }
        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent llamar = new Intent(Intent.ACTION_DIAL);
                llamar.setData(Uri.parse("tel: 3116946498"));

                if(llamar.resolveActivity(getPackageManager()) != null){
                    startActivity(llamar);
                }
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapa = new Intent(Intent.ACTION_VIEW);
                mapa.setData(Uri.parse("geo:6.303441,-75.564835"));
                startActivity(mapa);
            }
        });

        Wi_fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wifi = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(wifi);
            }
        });

    }
}