package com.example.fuzzylog;

import java.util.ArrayList;

public class Rules {

    String Temp;
    String Humid;
    double Res;

    public Rules(String temp, String humid, double result){
        this.Temp=temp;
        this.Humid=humid;
        this.Res=result;
    }

    public double Temp_is(int x){
        double res;
        if (this.Temp.equals("Cold"))
            res = Val.Temp_cold(x);
        else if (this.Temp.equals("Medium"))
            res = Val.Temp_medium(x);
        else
            res = Val.Temp_hot(x);
        return res;
    }

    public double Humid_is(int x){
        double res;
        if (this.Humid.equals("Dry"))
            res= Val.Humid_dry(x);
        else if (this.Humid.equals("Normal"))
            res = Val.Humid_normal(x);
        else
            res= Val.Humid_wet(x);
        return res;
    }

    public double R_is(){
        return this.Res;
    }

    public static ArrayList<Rules> generateRules(){
        ArrayList<Rules> rules = new ArrayList<Rules>();

        rules.add(new Rules("Cold", "Dry", Val.R_slow()));
        rules.add(new Rules("Medium", "Dry", Val.R_slow()));
        rules.add(new Rules("Cold", "Normal", Val.R_slow()));

        rules.add(new Rules("Hot", "Dry", Val.R_moderate()));
        rules.add(new Rules("Medium", "Normal", Val.R_moderate()));
        rules.add(new Rules("Cold", "Wet", Val.R_moderate()));

        rules.add(new Rules("Hot", "Normal", Val.R_fast()));
        rules.add(new Rules("Hot", "Wet", Val.R_fast()));
        rules.add(new Rules("Medium", "Wet", Val.R_fast()));

        return rules;
    }
}
