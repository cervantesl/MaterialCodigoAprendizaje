package com.example.lucas.ejercicios;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    android.webkit.WebView navegador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambioActividad(view);
            }
        });

        navegador = (android.webkit.WebView) findViewById(R.id.webkit);
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.loadUrl("http://www.upv.es");
        navegador.setWebViewClient(new WebViewClient());
    }


    public void cambioActividad(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
