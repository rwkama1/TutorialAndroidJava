package uy.edu.bios.checkradiotoggle;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    protected CheckBox cbMeInteresa;
    protected CheckBox cbLoRecomendare;
    protected RadioGroup rgEjemploConocido;
    protected RadioButton rbYaLoConocia;
    protected RadioButton rbEsNuevoParaMi;
    protected ToggleButton tbEstado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cbMeInteresa = (CheckBox)findViewById(R.id.cbMeInteresa);
        cbLoRecomendare = (CheckBox)findViewById(R.id.cbLoRecomendare);
        rgEjemploConocido = (RadioGroup)findViewById(R.id.rgEjemploConocido);
        rbYaLoConocia = (RadioButton)findViewById(R.id.rbYaLoConocia);
        rbEsNuevoParaMi = (RadioButton)findViewById(R.id.rbEsNuevoParaMi);
        tbEstado = (ToggleButton)findViewById(R.id.tbEstado);

        cbMeInteresa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbMeInteresaOnCheckedChanged(buttonView, isChecked);
            }

        });

        rgEjemploConocido.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                rgEjemploConocidoOnCheckedChanged(group, checkedId);
            }

        });
    }

    public void casillasOnClick(View v) {
        switch (v.getId()) {
            case R.id.cbMeInteresa:
                Toast.makeText(this, "A este usuario " + (((CheckBox)v).isChecked() ? "" : "NO ") + "le interesa el ejemplo.", Toast.LENGTH_SHORT).show();

                break;
            case R.id.cbLoRecomendare:
                Toast.makeText(this, "Este usuario " + (((CheckBox)v).isChecked() ? "" : "NO ") + "recomendará el ejemplo.", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    protected void cbMeInteresaOnCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.i("MisLogs", "A este usuario " + (isChecked ? "" : "NO ") + "le interesa el ejemplo.");
    }

    protected void rgEjemploConocidoOnCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rbYaLoConocia:
                Toast.makeText(this, "Este usuario ya conocía el ejemplo.", Toast.LENGTH_SHORT).show();

                break;
            case R.id.rbEsNuevoParaMi:
                Toast.makeText(this, "Este usuario NO conocía el ejemplo.", Toast.LENGTH_SHORT).show();

                break;
        }

        RadioButton radioButtonSeleccionado = (RadioButton)findViewById(checkedId);

        Log.i("MisLogs", "Se seleccionó: " + radioButtonSeleccionado.getText().toString());
    }

    public void tbEstadoOnClick(View v) {
        boolean estado = ((ToggleButton)v).isChecked();

        cbMeInteresa.setEnabled(estado);
        cbLoRecomendare.setEnabled(estado);
        rbYaLoConocia.setEnabled(estado);
        rbEsNuevoParaMi.setEnabled(estado);
    }

}
