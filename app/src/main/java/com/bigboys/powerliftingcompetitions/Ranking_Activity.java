package com.bigboys.powerliftingcompetitions;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;

public class Ranking_Activity extends AppCompatActivity  {

    Spinner sp_parent,sp_child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);


        sp_parent=(Spinner)findViewById(R.id.sp_parent);
        sp_child=(Spinner)findViewById(R.id.sp_child);


 ArrayAdapter<CharSequence> arrayAdapter_parent= ArrayAdapter.createFromResource(this,R.array.sex, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> arrayAdapter_female= ArrayAdapter.createFromResource(this,R.array.female_weight_categories, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> arrayAdapter_male= ArrayAdapter.createFromResource(this,R.array.male_weight_categories, android.R.layout.simple_spinner_item);

        sp_parent.setAdapter(arrayAdapter_parent);

sp_parent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(i==0)
        {
            sp_child.setAdapter(arrayAdapter_male);
        }
        else
        {  sp_child.setAdapter(arrayAdapter_female);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});

    }


}