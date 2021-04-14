package uy.edu.bios.navegadorweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected EditText etUrl;
    protected WebView wvNavegador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etUrl = (EditText)findViewById(R.id.etUrl);
        wvNavegador = (WebView)findViewById((R.id.wbNavegador));
        wvNavegador.setWebViewClient(new WebViewClient());

        String url = getIntent().getDataString();

        if (url == null) {
            url = "http://www.google.com";
        }

        etUrl.setText(url);
        wvNavegador.loadUrl(url);
        wvNavegador.requestFocus();

        etUrl.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return etUrlOnEditorAction(v, actionId, event);
            }

        });
    }

    protected boolean etUrlOnEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean manejado = false;

        if (actionId == EditorInfo.IME_ACTION_GO) {
            wvNavegador.loadUrl(etUrl.getText().toString());

            InputMethodManager gestorMetodoEntrada = (InputMethodManager)etUrl.getContext().getSystemService(INPUT_METHOD_SERVICE);
            gestorMetodoEntrada.hideSoftInputFromWindow(etUrl.getWindowToken(), 0);

            wvNavegador.requestFocus();

            manejado = true;
        }

        return manejado;
    }

}
