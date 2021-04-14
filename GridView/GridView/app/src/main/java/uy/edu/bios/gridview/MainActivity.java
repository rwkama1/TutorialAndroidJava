package uy.edu.bios.gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*public static final String EXTRA_CEDULA = "EXTRA_CEDULA";
    public static final String EXTRA_NOMBRE_COMPLETO = "EXTRA_NOMBRE_COMPLETO";
    public static final String EXTRA_DESCRIPCION = "EXTRA_DESCRIPCION";*/
    public static final String EXTRA_EMPLEADO = "EXTRA_EMPLEADO";


    protected GridView gvEmpleados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        gvEmpleados = (GridView)findViewById(R.id.gvEmpleados);

        List<Empleado> empleados = new ArrayList();
        empleados.add(new Empleado(11111111, "Juan Pérez"));
        empleados.add(new Empleado(22222222, "Laura Aguirre"));
        empleados.add(new Empleado(33333333, "Roberto Gómez"));
        empleados.add(new Empleado(44444444, "Ana Fernández"));
        empleados.add(new Empleado(55555555, "Leonardo Sosa"));
        empleados.add(new Empleado(66666666, "Pablo Alonso"));
        empleados.add(new Empleado(77777777, "Graciela Santos"));
        empleados.add(new Empleado(88888888, "Nicolás García"));
        empleados.add(new Empleado(99999999, "Angélica Domínguez"));
        empleados.add(new Empleado(10101010, "Estela López"));
        empleados.add(new Empleado(11111110, "Mauricio Pintos"));
        empleados.add(new Empleado(12121212, "Ximena Castro"));

        AdaptadorEmpleados adaptadorEmpleados = new AdaptadorEmpleados(this, empleados);
        gvEmpleados.setAdapter(adaptadorEmpleados);

        gvEmpleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gvEmpleadosOnItemClick(parent, view, position, id);
            }

        });
    }

    protected void gvEmpleadosOnItemClick(AdapterView<?> parent, View view, int position, long id) {
        Empleado empleado = (Empleado)parent.getItemAtPosition(position);

        Intent intencionDetalle = new Intent(this, DetalleEmpleadoActivity.class);

        /*intencionDetalle.putExtra(EXTRA_CEDULA, empleado.getCedula());
        intencionDetalle.putExtra(EXTRA_NOMBRE_COMPLETO, empleado.getNombreCompleto());
        intencionDetalle.putExtra(EXTRA_DESCRIPCION, empleado.getDescripcion());*/

        /*Bundle extras = new Bundle();
        extras.putInt(EXTRA_CEDULA, empleado.getCedula());
        extras.putString(EXTRA_NOMBRE_COMPLETO, empleado.getNombreCompleto());
        extras.putString(EXTRA_DESCRIPCION, empleado.getDescripcion());

        intencionDetalle.putExtras(extras);*/

        intencionDetalle.putExtra(EXTRA_EMPLEADO, empleado);

        startActivity(intencionDetalle);
    }

}
