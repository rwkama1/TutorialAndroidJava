package uy.edu.bios.holamundo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView tvMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /*tvMensaje = (TextView)findViewById(R.id.tvMensaje);

        tvMensaje.setText("¡Hola Android!");
        //tvMensaje.setText(R.string.otroMensaje);*/

        /*LinearLayout contenedor = new LinearLayout(this);
        contenedor.setGravity(Gravity.CENTER);
        setContentView(contenedor);

        Button boton = new Button(this);
        boton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        boton.setText("No Hago Nada");
        contenedor.addView(boton);*/
    }

}
