package com.example.chyht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    String data = "0 - гипертонии нет\n" +
                  "1 - скорее всего гипертонии нет\n" +
                  "2 - 50/50, обратитесь к врачу\n" +
                  "3 - скорее всего у Вас гипертония\n" +
                  "4 - у Вас гипертония";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle arguments = getIntent().getExtras();
        TextView hello = findViewById(R.id.yourres);
        hello.setText(arguments.get("result").toString());
        TextView txtRes = findViewById(R.id.txtRes);
        txtRes.setText(data);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}