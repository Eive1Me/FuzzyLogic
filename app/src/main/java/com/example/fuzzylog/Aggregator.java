package com.example.fuzzylog;

import java.util.ArrayList;
import java.util.Collections;

public class Aggregator {
    public static ArrayList<Double> aggregate(ArrayList<Double> b){
        ArrayList<Double> c = new ArrayList<>();
        int i=0;
        int j=0;

        while(i<9){
            ArrayList<Double> nowArray = new ArrayList<Double>();
            nowArray.add(b.get(j));
            nowArray.add(b.get(j+1));
            c.add((double) Collections.min(nowArray));
            j+=2;
            i++;
        }
        return c;
    }
}
