package com.example.lucas.ejercicios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String[] listOptions = new String[] {"Ejercicio.1: CheckBox ", "Ejercicio.2: WebViewActivity", "Ejercicio.3: MENU"};
    private ListView options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOptions);
        options = (ListView) findViewById(R.id.listOptions);
        options.setAdapter(adapter);

        options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(id);
                cambioActividad(view, (int)id);

                String text = (String) (options.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, "Item seleccionado: " + position +
                        ", Texto: " + text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cambioActividad(View view, int id) {
        Intent intent = null;

        switch (id) {
            case 0:
                intent = new Intent(this, CheckBoxActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                break;

        }
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
            return true;
        }
        if(id == R.id.checkbox) {
            Intent intent = new Intent(this, CheckBoxActivity.class);
            startActivity(intent);
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
