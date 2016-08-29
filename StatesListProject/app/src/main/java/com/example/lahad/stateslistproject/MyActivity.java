package com.example.lahad.stateslistproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

 /*           String[] people = {"John", "Peter", "Luis"};

            ArrayAdapter<String> peopleAdapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1,
                    people);

            ListView lv1 = (ListView) rootView.findViewById(R.id.listviewlayout);
            lv1.setAdapter(peopleAdapter);
*/
            String[] fruits = {"Sénégal", "Palestine", "Canada"};
            List<String> fruitAL = new ArrayList<String>(Arrays.asList(fruits));

           // ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(getActivity(),
               //     R.layout.listviewitemimg,
                 //   R.id.textviewitem1,
                   // fruitAL);

            //ListView lv = (ListView) rootView.findViewById(R.id.listviewlayout);
            //lv.setAdapter(fruitAdapter);


            ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1,
                    fruits);


            ListView lv = (ListView) rootView.findViewById(R.id.listviewlayout);
            lv.setAdapter(fruitAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        Log.i("hello", "Sénégal");
                        Toast t = Toast.makeText(getActivity(),"Hello Sénégal",Toast.LENGTH_LONG);
                        t.show();
                        startActivity(new Intent(getActivity(), MyActivity1.class));
                    } else if (position == 1) {
                        Toast t = Toast.makeText(getActivity(),"Hello Palestine",Toast.LENGTH_LONG);
                        t.show();
                        Log.i("hello", "Palestine");
                    } else if (position == 2) {
                        Toast t = Toast.makeText(getActivity(),"Hello Canada",Toast.LENGTH_LONG);
                        t.show();
                        Log.i("hello", "Canada");
                    }
                }
            });

            return rootView;
        }
    }
}
