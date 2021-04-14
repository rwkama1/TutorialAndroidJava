package uy.edu.bios.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    protected Spinner spDia;
    protected Spinner spMes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        spDia = (Spinner)findViewById(R.id.spDia);
        spMes = (Spinner)findViewById(R.id.spMes);

        String[] dias = { "domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado" };

        ArrayAdapter<String> adaptadorDias = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dias);
        adaptadorDias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDia.setAdapter(adaptadorDias);

        ArrayAdapter<CharSequence> adaptadorMeses = ArrayAdapter.createFromResource(this, R.array.meses, android.R.layout.simple_spinner_dropdown_item);
        adaptadorMeses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMes.setAdapter(adaptadorMeses);

        spDia.setOnItemSelectedListener(this);
        spMes.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spDia:
                Toast.makeText(MainActivity.this, "Día seleccionado: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                break;
            case R.id.spMes:
                Toast.makeText(MainActivity.this, "Mes seleccionado: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
