package com.bigboys.powerliftingcompetitions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Button;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Participants_Activity extends AppCompatActivity {
    Spinner sex;
    EditText weight,name,surname;
    Button buttonAdd;
    //////////








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
                !weight.equals("") && !sex.getSelectedItem().equals("Sex")) {


                    try {
                        http url = new URL("localhost:8080/athletes");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");

                        DataOutputStream wr= new DataOutputStream(
                                con.getOutputStream());

                        HashMap values = new HashMap<String, String>() {{
                            put("name",name.getText().toString());
                            put("surname",surname.getText().toString());
                            put("pesel","00000");
                            put("weight",weight.getText().toString());
                            put("sex",sex.getSelectedItem().toString());
                        }};
////////////////////////////////////////////////////////////////////////////////////
//url.set
                        //wr.writeBytes("sss","");


                        con.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();

                    }




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