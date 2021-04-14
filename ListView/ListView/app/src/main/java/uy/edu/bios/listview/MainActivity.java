package uy.edu.bios.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected ListView lvMeses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        lvMeses = (ListView)findViewById(R.id.lvMeses);

        String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "setiembre", "octubre", "noviembre", "diciembre" };

        ArrayAdapter adaptadorMeses = new ArrayAdapter(this, android.R.layout.simple_list_item_1, meses);
        lvMeses.setAdapter(adaptadorMeses);

        lvMeses.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvMesesOnItemClick(parent, view, position, id);
            }

        });
    }

    protected void lvMesesOnItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Mes seleccionado: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
    }

}
