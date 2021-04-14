package uy.edu.bios.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int CODIGO_PEDIDO_DEFINIR_MENSAJE = 1;


    protected TextView tvMensaje;
    protected Button btnDefinirMensaje;
    protected Button btnIrABios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvMensaje = (TextView)findViewById(R.id.tvMensaje);
        btnDefinirMensaje = (Button)findViewById(R.id.btnDefinirMensaje);
        btnIrABios = (Button)findViewById(R.id.btnIrABios);

        btnDefinirMensaje.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btnDefinirMensajeOnClick(v);
            }

        });
    }

    protected void btnDefinirMensajeOnClick(View v) {
        //Toast.makeText(this, "¡Hola mundo!", Toast.LENGTH_SHORT).show();

        Intent intencionDefinirMensaje = new Intent(getApplicationContext(), DefinirMensajeActivity.class);

        //startActivity(intencionDefinirMensaje);
        startActivityForResult(intencionDefinirMensaje, CODIGO_PEDIDO_DEFINIR_MENSAJE);
    }

    public void btnIrABiosOnClick(View v) {
        //Intent intencionIrABios = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-34.9057382,-56.1889189?z=18"));
        Intent intencionIrABios = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.biosportal.com"));

        if (intencionIrABios.resolveActivity(getPackageManager()) != null) {
            Intent intencionSelector = Intent.createChooser(intencionIrABios, "¿Qué navegador prefiere utilizar?");

            //startActivity(intencionIrABios);
            startActivity(intencionSelector);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case CODIGO_PEDIDO_DEFINIR_MENSAJE:
                if (resultCode == RESULT_OK) {
                    //tvMensaje.setText(data.getStringExtra("EXTRA_MENSAJE"));
                    tvMensaje.setText(data.getStringExtra(DefinirMensajeActivity.EXTRA_MENSAJE));

                    /*Bundle extras = data.getExtras();
                    tvMensaje.setText(extras.getString(DefinirMensajeActivity.EXTRA_MENSAJE));*/
                }

                break;
        }
    }

}
