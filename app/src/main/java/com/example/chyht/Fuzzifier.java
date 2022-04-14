package com.example.chyht;

import java.util.ArrayList;

public class Fuzzifier {

    public static double[] fuzzi(ArrayList<Rules> rules, int xBP, int xH, int xA, int xSM, int xHB) {
        System.out.println(xBP+" "+xH+" "+xA+" "+xSM+" "+xHB);
        double[] b = new double[32 * 5];
        int i = 0;
        int j = 0;
        while (j < 32) {
            b[i++] = rules.get(j).BP_is(xBP);
            b[i++] = rules.get(j).H_is(xH);
            b[i++] = rules.get(j).A_is(xA);
            b[i++] = rules.get(j).SM_is(xSM);
            b[i++] = rules.get(j).HB_is(xHB);
            System.out.println(rules.get(j).BP_is(xBP)+" "+rules.get(j).H_is(xH)+" "+rules.get(j).A_is(xA)+" "+rules.get(j).SM_is(xSM)+" "+rules.get(j).HB_is(xHB));
            j++;
        }

        return b;
    }
}
