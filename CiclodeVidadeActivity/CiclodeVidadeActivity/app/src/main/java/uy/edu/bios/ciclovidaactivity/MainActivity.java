package uy.edu.bios.ciclovidaactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String MIS_LOGS = "MIS_LOGS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.i(MIS_LOGS, "Los logs tienen un nivel (v, d, i, w, e), una etiqueta y un mensaje.");
        Log.d(MIS_LOGS, "Se ejecutó el método onCreate.");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(MIS_LOGS, "Se ejecutó el método onStart.");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(MIS_LOGS, "Se ejecutó el método onResume.");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(MIS_LOGS, "Se ejecutó el método onPause.");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(MIS_LOGS, "Se ejecutó el método onStop.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(MIS_LOGS, "Se ejecutó el método onRestart.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(MIS_LOGS, "Se ejecutó el método onDestroy.");
    }

}
