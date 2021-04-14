package uy.edu.bios.recibirbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Raul on 30/10/2017.
 */

public class OtroMensajesReceiver extends BroadcastReceiver {

    public static final String EXTRA_MENSAJE = "EXTRA_MENSAJE";
    public static final String MIS_LOGS = "MIS_LOGS";


    @Override
    public void onReceive(Context context, Intent intent) {
        String mensaje = intent.getStringExtra(EXTRA_MENSAJE);

        Log.i(MIS_LOGS, "Mensaje recibido: " + mensaje);

        if (mensaje.contains("(oculto)")) {
            abortBroadcast();
        } else {
            setResultData("procesado");
        }
    }

}
