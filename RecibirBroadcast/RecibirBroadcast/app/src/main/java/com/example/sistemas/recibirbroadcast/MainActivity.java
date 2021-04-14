package com.example.sistemas.recibirbroadcast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView tvMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje=(TextView)findViewById(R.id.tvMensaje);
        String mensaje=getIntent().getStringExtra("mensaje");
        if(mensaje==null)
        {
         mensaje="No se ha recibido un mensaje aun";
        }
        tvMensaje.setText(mensaje);
    }
}
