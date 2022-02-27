package com.bigboys.powerliftingcompetitions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Button;

import java.util.ArrayList;

public class Participants_Activity extends AppCompatActivity {
    Spinner sex;
    EditText weight,name,surname;
    Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sex = (Spinner) findViewById(R.id.spinnerSex);
        ArrayList<String> list = new ArrayList<>();
        list.add("Sex");
        list.add("Male");
        list.add("Female");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, list);

        sex.setAdapter(adapter);

        name = (EditText) findViewById(R.id.TextEditName);
        surname = (EditText) findViewById(R.id.TextEditSurname);

        weight = (EditText) findViewById(R.id.TextEditWeight);
        weight.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.equals("") && !surname.equals("")  &&
                !weight.equals("") && !sex.getSelectedItem().equals("Sex")){
                    //tutaj wysylamy do api dane
                }
                name.setText("");
                surname.setText("");
                weight.setText("");
                sex.setSelection(0);
            }
        });
    }
}