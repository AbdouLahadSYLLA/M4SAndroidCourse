package com.example.lahad.firebasestudent;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button btnsubmit;
    private EditText etdID,etFirtName;
    private DatabaseReference rootref;
    View rootView;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_main, container, false);

        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        rootref= FirebaseDatabase.getInstance().getReference();

        btnsubmit = (Button)rootView.findViewById(R.id.button);
        etdID = (EditText)rootView.findViewById(R.id.editText);
        etFirtName= (EditText)rootView.findViewById(R.id.editText2);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(etdID.getText().toString().equals("")&& etFirtName.getText().toString().equals(""))){

                    String id = etdID.getText().toString().trim();
                    String firsntame =  etFirtName.getText().toString().trim();
                    Student student = new Student(id, firsntame);
                    rootref.push().setValue(student);
                    Toast.makeText(getActivity(),"le données sont envoyées dans la base",Toast.LENGTH_LONG).show();

                }
                else if(etdID.getText().toString().equals("")&& etFirtName.getText().toString().equals("")) {

                    Toast.makeText(getActivity(),"veuillez remplir ces champs sont obligatoires",Toast.LENGTH_LONG).show();
                }

                

            }
        });

        return rootView;
    }
}
