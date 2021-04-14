package uy.edu.bios.pickers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    public static final String TAG_SELECTOR_FECHA = "TAG_SELECTOR_FECHA";
    public static final String TAG_SELECTOR_HORA = "TAG_SELECTOR_HORA";


    protected EditText etFecha;
    protected EditText etHora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etFecha = (EditText)findViewById(R.id.etFecha);
        etHora = (EditText)findViewById(R.id.etHora);
    }

    public void btnElegirFechaOnClick(View v) {
        SelectorFechaDialog dialogoFecha = new SelectorFechaDialog();
        dialogoFecha.show(getSupportFragmentManager(), TAG_SELECTOR_FECHA);
    }

    public void btnElegirHoraOnClick(View v) {
        SelectorHoraDialog dialogoHora = new SelectorHoraDialog();
        dialogoHora.show(getSupportFragmentManager(), TAG_SELECTOR_HORA);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        etFecha.setText(year + "/" + String.format("%1$02d", (month + 1)) + "/" + String.format("%1$02d", dayOfMonth));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        etHora.setText(String.format("%1$02d", hourOfDay) + ":" + String.format("%1$02d", minute));
    }

    public static class SelectorFechaDialog extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendario = Calendar.getInstance();
            int anio = calendario.get(Calendar.YEAR);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener)getActivity(), anio, mes, dia);
        }

    }

    public static class SelectorHoraDialog extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendario = Calendar.getInstance();
            int hora = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos = calendario.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener)getActivity(), hora, minutos, true);
        }

    }

}
