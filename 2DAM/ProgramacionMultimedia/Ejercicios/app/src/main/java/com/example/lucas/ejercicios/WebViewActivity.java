package com.example.lucas.ejercicios;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {

    WebView navegador;
    ProgressBar barraProgres;
    ProgressDialog prgDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        navegador = (WebView) findViewById(R.id.webkit);
        navegador.loadUrl("http://www.google.es");
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.setWebViewClient(new WebViewClient());

        barraProgres = (ProgressBar) findViewById(R.id.barraProgres);
        barraProgres.setVisibility(View.VISIBLE);

        prgDialog = new ProgressDialog(this);
        prgDialog.setMessage("Descargando la pagina. Porfavor espere...");

        navegador.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int currentProgres) {
                barraProgres.incrementProgressBy(currentProgres);
                if(currentProgres == 100) {
                    barraProgres.setVisibility(View.GONE);
                }
            }
        });

        prgDialog.show();
        prgDialog.hide();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambioActividad(view);
            }
        });



    }


    public void cambioActividad(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.checkbox) {
            Intent intent = new Intent(this, CheckBoxActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.webview) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
