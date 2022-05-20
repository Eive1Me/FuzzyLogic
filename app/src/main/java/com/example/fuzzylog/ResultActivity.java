package com.example.fuzzylog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    String data = "0 - малая скорость\n" +
            "1 - средняя скорость\n" +
            "2 - высокая скорость";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle arguments = getIntent().getExtras();

        ImageView fanImg = findViewById(R.id.imageView);

        TextView resultNum = findViewById(R.id.ResultNumTv);
        double value = (double) arguments.get("result");
        double scale = Math.pow(10, 3);
        double result = Math.ceil(value * scale) / scale;
        resultNum.setText(String.valueOf(result));

        TextView textRes = findViewById(R.id.ResultTv);
        Double doRes = Double.parseDouble(arguments.get("result").toString());
        if (doRes<0.75)
            textRes.setText("Малая скорость");
        else if (doRes<1.75)
            textRes.setText("Средняя скорость");
        else
            textRes.setText("Высокая скорость");

        ArrayList b = (ArrayList) arguments.get("points");
        GraphView graph = (GraphView) findViewById(R.id.ResultGraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        series.appendData(new DataPoint(1,Math.ceil((double)b.get(0) * Math.pow(10,2)) / Math.pow(10,2)),true,500);
        series.appendData(new DataPoint(2,Math.ceil((double)b.get(1) * Math.pow(10,2)) / Math.pow(10,2)),true,500);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"Температура " + String.format("%.2f",b.get(0)) , "Влажность " + String.format("%.2f",b.get(1))});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.addSeries(series);

        float animSpeed;

        if (doRes<0.75)
            animSpeed = 90f;
        else if (doRes<1.75)
            animSpeed = 360f;
        else
            animSpeed = 720f;

        RotateAnimation anim = new RotateAnimation(0f, animSpeed, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);

        fanImg.startAnimation(anim);
    }

    public void getResultsTable(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                data, Toast.LENGTH_LONG);
        toast.show();
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}