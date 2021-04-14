package uy.edu.bios.enviarbroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String ACCION_MENSAJE_ENVIADO = "uy.edu.bios.enviarbroadcast.ACCION_MENSAJE_ENVIADO";
    public static final String EXTRA_MENSAJE = "EXTRA_MENSAJE";


    protected EditText etMensaje;
    protected Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etMensaje = (EditText)findViewById(R.id.etMensaje);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btnEnviarOnClick(v);
            }

        });
    }

    protected void btnEnviarOnClick(View v) {
        String mensaje = etMensaje.getText().toString();

        Intent intencionBroadcast = new Intent(ACCION_MENSAJE_ENVIADO);
        intencionBroadcast.putExtra(EXTRA_MENSAJE, mensaje);
        intencionBroadcast.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);

        //sendBroadcast(intencionBroadcast);
        sendOrderedBroadcast(intencionBroadcast, null);
    }

}
