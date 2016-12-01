package com.example.lucas.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void hacerFoto(View v) {
        String mediaStorageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
        String timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss", Locale.ENGLISH).format(new Date());
        Uri uriFichero = Uri.fromFile(new java.io.File(mediaStorageDir + File.separator + "IMG_" + timeStamp + ".jpg"));

        Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriFichero);

        startActivityForResult(camaraIntent, 1);
    }

    public void elPais(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String urlElPais = "http://www.elpais.com";
        intent.setData(Uri.parse(urlElPais));
        startActivity(intent);
    }

    public void cambiarActividad(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
