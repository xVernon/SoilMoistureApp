package com.example.SoilMoisture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseOption extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_NUMBER = "com.example.a531calculator.example.EXTRA_NUMBER";
    public static String choosenOption;

    boolean clicked = false;
    int workout = 0;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_option);

        Button day1 = (Button) findViewById(R.id.button2);
        Spinner optionList = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        optionList.setAdapter(adapter);
        optionList.setOnItemSelectedListener(this);

        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
                if(clicked)
                {
                    workout = 1;
                    Intent myIntent = new Intent(ChooseOption.this, Stats.class);
                    myIntent.putExtra(EXTRA_NUMBER,1);
                    startActivity(myIntent);
                }
            }
        });
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        choosenOption = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String text = "You need to choose option first!";
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
}