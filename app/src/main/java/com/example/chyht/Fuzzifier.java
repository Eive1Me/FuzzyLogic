package com.example.chyht;

import java.util.ArrayList;

public class Fuzzifier {

    public static ArrayList<Double> fuzzi(ArrayList<Rules> rules, int xBP, int xH, int xA, int xSM, int xHB) {
        ArrayList<Double> b = new ArrayList();
        int i = 0;
        int j = 0;
        while (j < 32) {
            b.add(rules.get(j).BP_is(xBP));
            b.add(rules.get(j).H_is(xH));
            b.add(rules.get(j).A_is(xA));
            b.add(rules.get(j).SM_is(xSM));
            b.add(rules.get(j).HB_is(xHB));
            j++;
        }

        return b;
    }
}
