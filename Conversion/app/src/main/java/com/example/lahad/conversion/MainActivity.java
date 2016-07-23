package com.example.lahad.conversion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button valider,effacer;
    EditText valeur;
    TextView resultat;
    float result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        valider= (Button) findViewById(R.id.convert);
        effacer= (Button) findViewById(R.id.effacer);
        valeur= (EditText) findViewById(R.id.col2);
        resultat= (TextView) findViewById(R.id.resultat);


        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!valeur.getText().toString().equals("")){

                    float from_value;
                    try {
                        from_value = Float.parseFloat(valeur.getText().toString());
                        result =   (float) (439.36*from_value);
                        resultat.setText("le resultat de la conversion est : "+result);
                        valeur.setText("");
                    }
                    catch(NumberFormatException ex) {
                        from_value = (float) 0.0; // default ??
                    }

                    //float convertie = Float.parseFloat(valeur.getText().toString());
                    //result =   (float) (439.36*convertie);

                    //resultat.setText("le resultat de la conversion est : "+result);

                } else if(valeur.getText().toString().equals("")){

                    Toast.makeText(MainActivity.this,"le champs est requis",Toast.LENGTH_LONG).show();
                }
            }
        });

        effacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valeur.setText("");
                resultat.setText("");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
