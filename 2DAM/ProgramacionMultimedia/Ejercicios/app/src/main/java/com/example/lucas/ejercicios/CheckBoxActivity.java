package com.example.lucas.ejercicios;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_activity);
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

    public void cambioActividad(View vista) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void onCheckboxClicked(View vista) {
        boolean checked = ((CheckBox) vista).isChecked();
        String text = ((CheckBox) vista).getText().toString();

        if(checked) {
            Toast.makeText(CheckBoxActivity.this, "Seleciona elemento: " + text, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CheckBoxActivity.this,"Deselecciona elemento: " + text,Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.checkbox) {
            return true;
        }
        if(id == R.id.webview) {
            Intent intent = new Intent(this, WebViewActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
