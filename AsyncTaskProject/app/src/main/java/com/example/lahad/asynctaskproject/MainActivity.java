package com.example.lahad.asynctaskproject;

import android.support.v7.app.AppCompatActivity;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button load_img;
    ImageView img;
    Bitmap bitmap;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load_img = (Button) findViewById(R.id.load);
        img = (ImageView) findViewById(R.id.img);


        load_img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new LoadImage().execute();
            }
        });

    }

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();

        }

        protected Bitmap doInBackground(String... args) {
            try {
                URL url = new URL("https://github.com/AbdouLahadSYLLA/M4SAndroidCourse/blob/master/MyCityOfBirth.PNG");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                    throw new Exception("Failed to connect");
                }
                InputStream is = con.getInputStream();
                publishProgress();
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                is.close();
                return bitmap;
            } catch (Exception e) {
                Log.e("Image", "Failed to load image", e);
                Log.e("error", e.getMessage());
            }
            return null;
        }

        protected void onPostExecute(Bitmap image) {

            if (image != null) {
                img.setImageBitmap(image);
                pDialog.dismiss();

            } else {

                pDialog.dismiss();
                Toast.makeText(MainActivity.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

            }
        }
    }
}





