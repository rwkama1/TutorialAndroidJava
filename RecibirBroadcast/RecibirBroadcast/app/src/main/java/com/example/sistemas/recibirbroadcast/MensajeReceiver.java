package com.example.sistemas.recibirbroadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by sistemas on 30/10/2017.
 */

public class MensajeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent)
    {
      String mensaje=intent.getStringExtra("mensaje");
        Intent intencionMainAcivity=new Intent(context,MainActivity.class);//Creo un intent explicito,
        //en el contexto no uso un this, porque me llega un contexto como parametro
        intencionMainAcivity.putExtra("mensaje",mensaje);
        PendingIntent intencionContenido=PendingIntent.getActivity(context,1,intencionMainAcivity,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder constructoorNotificacion=new NotificationCompat.Builder(context);
        constructoorNotificacion
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("Ha llegado un mensaje.")
                .setContentText("Haz click en esta notificación para verlo.")
                .setContentIntent(intencionContenido)
                .setAutoCancel(true);
        NotificationManager gestorNotificacines=((NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE));
        gestorNotificacines.notify(1,constructoorNotificacion.build());

    }
}
