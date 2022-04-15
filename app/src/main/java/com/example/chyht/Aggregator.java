package com.example.chyht;

import java.util.ArrayList;
import java.util.Collections;

public class Aggregator {
    public static ArrayList<Double> aggregate(ArrayList<Double> b){
        ArrayList<Double> c = new ArrayList<>();
        int i=0;
        int j=0;

        while(i<32){
            ArrayList<Double> nowArray = new ArrayList<Double>();
            nowArray.add(b.get(j));
            nowArray.add(b.get(j+1));
            nowArray.add(b.get(j+2));
            nowArray.add(b.get(j+3));
            nowArray.add(b.get(j+4));
            c.add((double) Collections.min(nowArray));
            j+=5;
            i++;
        }
        return c;
    }
}
