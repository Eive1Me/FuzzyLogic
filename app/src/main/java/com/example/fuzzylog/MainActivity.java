package com.example.fuzzylog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView HumidTv,TempTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HumidTv = findViewById(R.id.HumidTv);
        TempTv = findViewById(R.id.TempTv);
    }

    public void getResult(View view){
        try {
            ArrayList<Rules> rules = Rules.generateRules();
            ArrayList<Double> b = Fuzzifier.fuzzy(rules, Integer.parseInt(TempTv.getText().toString()), Integer.parseInt(HumidTv.getText().toString()));
            ArrayList<Double> c = Aggregator.aggregate(b);
            double defRes = Defuzzifier.defuzzy(c, rules);

            ArrayList<Double> badRes = new ArrayList<>();
            double tmp = Val.Temp_hot(Integer.parseInt(TempTv.getText().toString()));
            System.out.println(tmp);
            badRes.add(tmp);
            tmp = Val.Humid_wet(Integer.parseInt(HumidTv.getText().toString()));
            System.out.println(tmp + "\n-----");
            badRes.add(tmp);

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("result", defRes);
            intent.putExtra("points", badRes);
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Заполните все поля!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}