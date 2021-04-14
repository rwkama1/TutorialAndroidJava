package com.example.sistemas.enviarbroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String ACCION_MENSAJE_ENVIADO="com.example.sistemas.enviarbroadcast.ACCION_MENSAJE_ENVIADO";
    protected EditText etMensaje;
    protected Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Lo que hace es cuando se pulsa , se envia un mensaje BroadCast mio
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMensaje=(EditText) findViewById(R.id.etMensaje);
        btnEnviar=(Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEnviaronClick(v);

            }
        });
    }
    protected void btnEnviaronClick(View v)
    {
        String mensaje=etMensaje.getText().toString();
        Intent intentBroadCast=new Intent(ACCION_MENSAJE_ENVIADO);
        intentBroadCast.putExtra("mensaje",mensaje);
        intentBroadCast.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);//indica que el Intent implica una accion en la cual el usuario va
        // a tener una cierta participacion,le sube la Prioridad para que se envie
        sendBroadcast(intentBroadCast);
    }
}
