package com.example.lucas.plantilla;

import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Lucas on 06/11/2016.
 */
public class FuncionAsyncTask extends AsyncTask <Long, Integer, Boolean> {
    AsyncTaskClass a = new AsyncTaskClass();
    protected Boolean doInBackground(Long... params) {
        for(int i=1; i<=10; i++) {
            AsyncTaskClass.tareaLarga();

            publishProgress(i*10);

            if(isCancelled())
                break;
        }

        return true;

    }

    protected void onProgressUpdate(Integer... values) { //Desde este metodo podemos pasar info al thread main
        int progreso = values[0].intValue();
        a.barraProgreso.setProgress(progreso);
    }

    protected void onPreExecute() {
        //resultField.setText("Empieza a calcular con thread");
        a.barraProgreso.setMax(100);
        a.barraProgreso.setProgress(0);

    }
    protected void onPostExecute(Boolean result) {
        //resultField.setText("Acaba de calcular con thread");

    }
}
