package com.example.fuzzylog;

import java.util.ArrayList;

public class Defuzzifier {
    public static double defuzzy(ArrayList<Double> c, ArrayList<Rules> rules){
        int i = 0;
        double sumNumerator = 0;
        double sumDenominator = 0;

        while (i < 9)
        {
            sumNumerator += c.get(i) * rules.get(i).R_is();
            sumDenominator += c.get(i);
            i++;
        }
        System.out.println( sumNumerator+" "+sumDenominator);
        if (sumNumerator == 0)
            return 0;
        return ((double)sumNumerator / sumDenominator);
    }
}
