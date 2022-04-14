package com.example.chyht;

import java.util.ArrayList;

public class Defuzzifier {
    public static double defuzzi(double[] c, ArrayList<Rules> rules){
        int i = 0;
        double sumNumerator = 0;
        double sumDenominator = 0;

        while (i < 32)
        {
            sumNumerator += c[i] * rules.get(i).R_is();
            sumDenominator += c[i];
            System.out.println(c[i]);
            i++;
        }
        System.out.println(sumNumerator+" "+sumDenominator);
        if (sumNumerator == 0)
            return 0;
        return ((double)sumNumerator / sumDenominator);
    }
}
