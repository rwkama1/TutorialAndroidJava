package com.example.sistemas.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected CheckBox cbMonitorearCargador;
    private CargadorConectadoReceiver cargadorConectadoReceiver;
    private IntentFilter filtroAccionCargadorConectadoReceiver;//esto es como definir intentFilter en el Manifests
    //lo hacemos progrematicamente
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbMonitorearCargador=(CheckBox)findViewById(R.id.cbMonitorearCargador);
        cargadorConectadoReceiver =new CargadorConectadoReceiver();
        filtroAccionCargadorConectadoReceiver=new IntentFilter(Intent.ACTION_POWER_CONNECTED);

        cbMonitorearCargador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
            });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(cbMonitorearCargador.isChecked())
        {
            registerReceiver(cargadorConectadoReceiver,filtroAccionCargadorConectadoReceiver);//queda escuchando el tipo de accion definid
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(cargadorConectadoReceiver);

    }
    protected void cbMonitorearCargadorOnClick(View v)
    {
        if(cbMonitorearCargador.isChecked())
        {
            registerReceiver(cargadorConectadoReceiver,filtroAccionCargadorConectadoReceiver);
        }
        else
        {
            unregisterReceiver(cargadorConectadoReceiver);
        }
    }
    protected class CargadorConectadoReceiver extends BroadcastReceiver//es la clase de mi BroadCastReciver
    {
        @Override
        public void onReceive(Context context, Intent intent) {// el intente que se recibe con sendBroadcast
            Toast.makeText(MainActivity.this,"Se ha conectado el cargador.",Toast.LENGTH_SHORT).show();

        }//tiene que estar registrado dinamicamente en tiempo de ejecucion
    }

    }

