package uy.edu.bios.autocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    protected AutoCompleteTextView actvPais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        actvPais = (AutoCompleteTextView)findViewById(R.id.actvPais);

        String[] paises = getResources().getStringArray(R.array.paises);

        ArrayAdapter<String> adaptadorPaises = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        actvPais.setAdapter(adaptadorPaises);

        actvPais.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                actvPaisOnItemClick(parent, view, position, id);
            }

        });

        actvPais.setOnEditorActionListener(this);
    }

    protected void actvPaisOnItemClick(AdapterView<?> parent, View view, int position, long id) {
        ocultarTecladoYMostrarPaisSeleccionado();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean manejado = false;

        if (actionId == 1000) {
            ocultarTecladoYMostrarPaisSeleccionado();

            return true;
        }

        return manejado;
    }

    protected void ocultarTecladoYMostrarPaisSeleccionado() {
        InputMethodManager gestorMetodoEntrada = (InputMethodManager)actvPais.getContext().getSystemService(INPUT_METHOD_SERVICE);
        gestorMetodoEntrada.hideSoftInputFromWindow(actvPais.getWindowToken(), 0);

        Toast.makeText(this, "País seleccionado: " + actvPais.getText().toString(), Toast.LENGTH_SHORT).show();
    }

}
