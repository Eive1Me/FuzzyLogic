package com.example.chyht;

import static com.example.chyht.Rules.genRules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView BP;
    TextView A;
    TextView HB;
    int hd;
    int sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HB = findViewById(R.id.pulse);
        A = findViewById(R.id.age);
        BP = findViewById(R.id.bp);
    }

    public void onBtnHdClick(View view) {
        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();
        // Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.yhd:
                if (checked){
                    hd=1;
                }
                break;
            case R.id.nhd:
                if (checked){
                    hd=0;
                }
                break;
        }
    }

    public void onBtnSmClick(View view) {
        // если переключатель отмечен
        boolean checked = ((RadioButton) view).isChecked();
        // Получаем нажатый переключатель
        switch(view.getId()) {
            case R.id.ysmoke:
                if (checked){
                    sm=1;
                }
                break;
            case R.id.nsmoke:
                if (checked){
                    sm=0;
                }
                break;
        }
    }

    public void getRes(View view){
        try {
            ArrayList<Rules> rules = genRules();
            ArrayList<Double> b = Fuzzifier.fuzzi(rules, Integer.valueOf(BP.getText().toString()), hd, Integer.valueOf(A.getText().toString()), sm, Integer.valueOf(HB.getText().toString()));
            ArrayList<Double> c = Aggregator.aggregate(b);
            double defRes = Defuzzifier.defuzzi(c, rules);

            ArrayList<Double> badRes = new ArrayList<>();
            badRes.add(Perems.BP_high(Integer.valueOf(BP.getText().toString())));
            badRes.add(Perems.H_yes(hd));
            badRes.add(Perems.A_old(Integer.valueOf(A.getText().toString())));
            badRes.add(Perems.SM_yes(sm));
            badRes.add(Perems.HB_high(Integer.valueOf(HB.getText().toString())));

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("result", defRes);
            intent.putExtra("points", badRes);
            startActivity(intent);
        }catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Заполните все поля!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}