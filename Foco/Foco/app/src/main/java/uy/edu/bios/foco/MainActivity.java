package uy.edu.bios.foco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected EditText etCuatro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etCuatro = (EditText)findViewById(R.id.etCuatro);

        //etCuatro.setNextFocusDownId(R.id.etUno);
    }

}
