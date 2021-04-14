package uy.edu.bios.intents;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DefinirMensajeActivity extends AppCompatActivity {

    public static String EXTRA_MENSAJE = "EXTRA_MENSAJE";


    protected EditText etMensaje;
    protected Button btnDefinir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_definir_mensaje);

        etMensaje = (EditText)findViewById(R.id.etMensaje);
        btnDefinir = (Button)findViewById(R.id.btnDefinir);

        btnDefinir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btnDefinirOnClick(v);
            }

        });
    }

    protected void btnDefinirOnClick(View v) {
        String mensaje = etMensaje.getText().toString();

        if (mensaje.length() > 0) {
            Intent intencionRegresar = new Intent(getApplicationContext(), MainActivity.class);
            //intencionRegresar.putExtra("EXTRA_MENSAJE", mensaje);
            intencionRegresar.putExtra(EXTRA_MENSAJE, mensaje);

            setResult(RESULT_OK, intencionRegresar);
            finish();
        } else {
            //Toast.makeText(this, "Debe introducir un mensaje.", Toast.LENGTH_LONG).show();
            etMensaje.setError("Debe introducir un mensaje.");
        }
    }

}
