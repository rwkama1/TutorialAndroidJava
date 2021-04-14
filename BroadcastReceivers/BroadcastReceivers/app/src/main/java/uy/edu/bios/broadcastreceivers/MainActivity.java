package uy.edu.bios.broadcastreceivers;

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
    private IntentFilter filtroAccionCargadorConectadoReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cbMonitorearCargador = (CheckBox)findViewById(R.id.cbMonitorearCargador);

        cargadorConectadoReceiver = new CargadorConectadoReceiver();
        filtroAccionCargadorConectadoReceiver = new IntentFilter(Intent.ACTION_POWER_CONNECTED);

        cbMonitorearCargador.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cbMonitorearCargadorOnClick(v);
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (cbMonitorearCargador.isChecked()) {
            registerReceiver(cargadorConectadoReceiver, filtroAccionCargadorConectadoReceiver);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(cargadorConectadoReceiver);
    }

    protected void cbMonitorearCargadorOnClick(View v) {
        if (cbMonitorearCargador.isChecked()) {
            registerReceiver(cargadorConectadoReceiver, filtroAccionCargadorConectadoReceiver);
        } else {
            unregisterReceiver(cargadorConectadoReceiver);
        }
    }

    protected class CargadorConectadoReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this, "Se ha conectado el cargador.", Toast.LENGTH_SHORT).show();
        }

    }

}
