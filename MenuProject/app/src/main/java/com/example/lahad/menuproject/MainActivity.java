package com.example.lahad.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sms,phone,web,map,share,newActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sms = (Button)findViewById(R.id.sms_id);

        phone = (Button)findViewById(R.id.phone_id);
        web = (Button)findViewById(R.id.web_id);
        map = (Button)findViewById(R.id.map_id);
        share = (Button)findViewById(R.id.share_id);
        newActivity = (Button)findViewById(R.id.new_id);

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent sms = new Intent(Intent.ACTION_SENDTO);
                sms.setData(Uri.parse("smsto:"+ Uri.encode("00221773073262")));
                sms.putExtra("sms_body","Hello");
                startActivity(sms);

            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:00221773073262") );
                startActivity(call);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent webSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(webSiteIntent);

            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String geoUri = String.format("geo:38,899533,-77,036476");
                Uri geo = Uri.parse(geoUri);
                final Intent geoMap = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(geoMap);

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"CS639");
                intent.putExtra(Intent.EXTRA_TEXT," Join CS639");
                startActivity(Intent.createChooser(intent," Share the love"));


            }
        });

        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);

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
            Toast t = Toast.makeText(this,"setting",Toast.LENGTH_LONG);
            t.show();
            return true;
        }
       else if (id == R.id.action_help) {
            Toast t = Toast.makeText(this,"help",Toast.LENGTH_LONG);
            t.show();

            Intent i = new Intent(this,HelpActivity.class);
            this.startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
