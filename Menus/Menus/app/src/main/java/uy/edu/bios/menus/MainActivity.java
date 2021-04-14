package uy.edu.bios.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MIS_LOGS = "MIS_LOGS";


    protected ListView lvColores;
    protected ImageView imgvAndroid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        lvColores = (ListView)findViewById(R.id.lvColores);
        imgvAndroid = (ImageView)findViewById(R.id.imgvAndroid);

        String[] colores = { "rojo", "naranja", "amarillo", "verde", "celeste", "azul", "violeta" };

        ArrayAdapter adaptadorColores = new ArrayAdapter(this, android.R.layout.simple_list_item_checked, colores);
        lvColores.setAdapter(adaptadorColores);

        lvColores.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if (checked) {
                    Log.i(MIS_LOGS, "Se seleccionó: " + lvColores.getItemAtPosition(position));
                } else {
                    Log.i(MIS_LOGS, "Se deseleccionó: " + lvColores.getItemAtPosition(position));
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.menu_contextual_lista, menu);

                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                mode.setTitle("Colores");

                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mniMostrarSeleccion:
                        StringBuilder coloresSeleccionados = new StringBuilder("Colores seleccionados: ");

                        SparseBooleanArray posicionesSeleccionadas = lvColores.getCheckedItemPositions();

                        for (int i = 0; i < posicionesSeleccionadas.size(); i++) {
                            if (posicionesSeleccionadas.valueAt(i)) {
                                coloresSeleccionados.append(lvColores.getItemAtPosition(posicionesSeleccionadas.keyAt(i))).append(" ");
                            }
                        }

                        Toast.makeText(MainActivity.this, coloresSeleccionados.toString().trim(), Toast.LENGTH_SHORT).show();

                        return true;
                    default:

                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }

        });

        registerForContextMenu(imgvAndroid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        /*if(menu instanceof MenuBuilder){
            ((MenuBuilder)menu).setOptionalIconsVisible(true);
        }*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mniOpcionBuscar:
                Toast.makeText(this, "Se seleccionó: Buscar", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.mniOpcionInfo:
                Toast.makeText(this, "Se seleccionó: Info", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.mniOpcionAgregar:
            case R.id.mniOpcionModificar:
            case R.id.mniOpcionEliminar:
                Toast.makeText(this, "Se seleccionó: " + item.getTitle(), Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch(v.getId()) {
            case R.id.imgvAndroid:
                getMenuInflater().inflate(R.menu.menu_contextual_imagen, menu);
                menu.setHeaderIcon(R.mipmap.ic_launcher);
                menu.setHeaderTitle("¿Qué quieres hacer?");

                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.mniSaludar:
                Toast.makeText(this, "¡Hola mundo!", Toast.LENGTH_SHORT).show();

                return true;
            default:

                return super.onContextItemSelected(item);
        }
    }

}
