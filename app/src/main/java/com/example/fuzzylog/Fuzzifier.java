package com.example.fuzzylog;

import java.util.ArrayList;

public class Fuzzifier {

    public static ArrayList<Double> fuzzy(ArrayList<Rules> rules, int temp, int humid) {
        ArrayList<Double> b = new ArrayList();
        int j = 0;
        while (j < 9) {
            b.add(rules.get(j).Temp_is(temp));
            b.add(rules.get(j).Humid_is(humid));
            j++;
        }

        return b;
    }
}
