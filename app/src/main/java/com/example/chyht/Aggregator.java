package com.example.chyht;

import java.util.ArrayList;
import java.util.Collections;

public class Aggregator {
    public static double[] aggregate(double[] b){
        double[] c = new double[32];
        int i=0;
        int j=0;

        while(i<32){
            ArrayList<Double> nowArray = new ArrayList<Double>();
            nowArray.add(b[j]);
            nowArray.add(b[j+1]);
            nowArray.add(b[j+2]);
            nowArray.add(b[j+3]);
            nowArray.add(b[j+4]);
            System.out.println(nowArray.get(0)+" "+nowArray.get(1)+" "+nowArray.get(2)+" "+nowArray.get(3)+" "+nowArray.get(4));
            Collections.sort(nowArray);
            c[i] = (double) nowArray.get(0);
            //c[i] = (nowArray.get(0)+nowArray.get(1)+nowArray.get(2)+nowArray.get(3)+nowArray.get(4))-(nowArray.get(0)*nowArray.get(1)*nowArray.get(2)*nowArray.get(3)*nowArray.get(4));
            j+=5;
            i++;
        }
        return c;
    }
}
