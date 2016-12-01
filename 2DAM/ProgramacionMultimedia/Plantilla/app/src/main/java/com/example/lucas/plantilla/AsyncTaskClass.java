package com.example.lucas.plantilla;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskClass extends AppCompatActivity {

    public ProgressBar barraProgreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        barraProgreso = (ProgressBar) findViewById(R.id.progressBar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void primoSinThread(View v) {
        EditText numero = (EditText) findViewById(R.id.num1);

        long numeroP = Long.parseLong(numero.getText().toString());

        Boolean esPrimo = ClaseMath.esPrimo(numeroP);

        TextView resultado = (TextView) findViewById(R.id.resultadoPrimo);

        if (esPrimo) {
            resultado.setText("Es primo");
        } else {
            resultado.setText("No es primo");
        }
    }

    public static void tareaLarga() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
    }

    public void asyncTask(View view) {
        Long parametro = (long) 400;
        Asyn asyncTask = new Asyn();
        asyncTask.execute();
    }

    private class Asyn extends AsyncTask <Long, Integer, Boolean>{

        @Override
        protected Boolean doInBackground(Long... params) {
            for(int i=1; i<=10; i++) {
                tareaLarga();
                publishProgress(i*10);
            }

            return true;
        }

        protected void onProgressUpdate(Integer... values) {
            int progreso = values[0].intValue();

            barraProgreso.setProgress(progreso);
        }

        @Override
        protected void onPreExecute() {
            barraProgreso.setMax(100);
            barraProgreso.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result)
                Toast.makeText(AsyncTaskClass.this, "Tarea finalizada!",
                        Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(AsyncTaskClass.this, "Tarea cancelada!",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
