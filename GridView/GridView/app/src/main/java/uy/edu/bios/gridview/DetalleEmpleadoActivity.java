package uy.edu.bios.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleEmpleadoActivity extends AppCompatActivity {

    protected ImageView imgvAvatar;
    protected TextView tvCedula;
    protected TextView tvNombreCompleto;
    protected TextView tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalle_empleado);

        imgvAvatar = (ImageView)findViewById(R.id.imgvAvatar);
        tvCedula = (TextView)findViewById(R.id.tvCedula);
        tvNombreCompleto = (TextView)findViewById(R.id.tvNombreCompleto);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);

        //Empleado empleado = new Empleado(getIntent().getIntExtra(MainActivity.EXTRA_CEDULA, 0), getIntent().getStringExtra(MainActivity.EXTRA_NOMBRE_COMPLETO), getIntent().getStringExtra(MainActivity.EXTRA_DESCRIPCION));

        /*Bundle extras = getIntent().getExtras();
        Empleado empleado = new Empleado(extras.getInt(MainActivity.EXTRA_CEDULA), extras.getString(MainActivity.EXTRA_NOMBRE_COMPLETO), extras.getString(MainActivity.EXTRA_DESCRIPCION));*/

        Empleado empleado = (Empleado)getIntent().getSerializableExtra(MainActivity.EXTRA_EMPLEADO);

        int idImagenAvatar = getResources().getIdentifier("empleado_" + empleado.getCedula(), "drawable", getPackageName());

        imgvAvatar.setImageResource(idImagenAvatar);
        tvCedula.setText(String.valueOf(empleado.getCedula()));
        tvNombreCompleto.setText(empleado.getNombreCompleto());
        tvDescripcion.setText(empleado.getDescripcion());
    }

}
