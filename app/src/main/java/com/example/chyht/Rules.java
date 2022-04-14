package com.example.chyht;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rules {

    String MBP;
    String MH;
    String MA;
    String MSM;
    String MHB;
    double MR;

    public Rules(String MBP, String MH, String MA, String MSM, String MHB, double MR){
        this.MBP=MBP;
        this.MH=MH;
        this.MA=MA;
        this.MSM=MSM;
        this.MHB=MHB;
        this.MR=MR;
    }

    public double BP_is(int x){
        double res;
        if (this.MBP.equals("BP_norm"))
            res=Perems.BP_norm(x);
        else
            res=Perems.BP_high(x);
        return res;
    }

    public double H_is(int x){
        double res;
        if (this.MH.equals("H_yes"))
            res=Perems.H_yes(x);
        else
            res=Perems.H_no(x);
        return res;
    }

    public double A_is(int x){
        double res;
        if (this.MA.equals("A_old"))
            res=Perems.A_old(x);
        else
            res=Perems.A_young_mid(x);
        return res;
    }

    public double SM_is(int x){
        double res;
        if (this.MSM.equals("SM_yes"))
            res=Perems.SM_yes(x);
        else
            res=Perems.SM_no(x);
        return res;
    }

    public double HB_is(int x){
        double res;
        if (this.MHB.equals("HB_norm"))
            res=Perems.HB_norm(x);
        else
            res=Perems.HB_high(x);
        return res;
    }

    public double R_is(){
        return this.MR;
    }

    public static ArrayList<Rules> genRules(){
        ArrayList<Rules> rules = new ArrayList<Rules>();

        rules.add(new Rules("BP_norm", "H_no", "A_young_mid", "SM_no", "HB_norm", Perems.R_no()));
        rules.add(new Rules("BP_norm", "H_no", "A_young_mid", "SM_no", "HB_high", Perems.R_no()));
        rules.add(new Rules("BP_norm", "H_no", "A_young_mid", "SM_yes", "HB_norm", Perems.R_no()));
        rules.add(new Rules("BP_norm", "H_no", "A_old", "SM_no", "HB_norm", Perems.R_no()));
        rules.add(new Rules("BP_norm", "H_yes", "A_old", "SM_no", "HB_norm", Perems.R_no()));

        rules.add(new Rules("BP_high", "H_no", "A_young_mid", "SM_no", "HB_norm", Perems.R_maybe_no()));
        rules.add(new Rules("BP_high", "H_yes", "A_young_mid", "SM_no", "HB_norm", Perems.R_50()));
        rules.add(new Rules("BP_high", "H_no", "A_old", "SM_no", "HB_norm", Perems.R_maybe_yes()));
        rules.add(new Rules("BP_high", "H_no", "A_young_mid", "SM_yes", "HB_norm", Perems.R_maybe_no()));
        rules.add(new Rules("BP_high", "H_no", "A_young_mid", "SM_no", "HB_high", Perems.R_50()));

        rules.add(new Rules("BP_norm", "H_yes", "A_old", "SM_no", "HB_norm", Perems.R_maybe_no()));
        rules.add(new Rules("BP_norm", "H_yes", "A_young_mid", "SM_yes", "HB_norm", Perems.R_maybe_no()));
        rules.add(new Rules("BP_norm", "H_yes", "A_young_mid", "SM_no", "HB_high", Perems.R_maybe_no()));
        rules.add(new Rules("BP_norm", "H_no", "A_old", "SM_yes", "HB_norm", Perems.R_no()));
        rules.add(new Rules("BP_norm", "H_no", "A_old", "SM_no", "HB_high", Perems.R_maybe_no()));

        rules.add(new Rules("BP_norm", "H_no", "A_young_mid", "SM_yes", "HB_high", Perems.R_no()));
        rules.add(new Rules("BP_high", "H_yes", "A_old", "SM_yes", "HB_norm", Perems.R_yes()));
        rules.add(new Rules("BP_high", "H_yes", "A_old", "SM_no", "HB_high", Perems.R_yes()));
        rules.add(new Rules("BP_high", "H_yes", "A_young_mid", "SM_yes", "HB_high", Perems.R_yes()));
        rules.add(new Rules("BP_high", "H_no", "A_old", "SM_yes", "HB_high", Perems.R_yes()));

        rules.add(new Rules("BP_norm", "H_yes", "A_old", "SM_yes", "HB_high", Perems.R_maybe_yes()));
        rules.add(new Rules("BP_high", "H_yes", "A_old", "SM_yes", "HB_high", Perems.R_yes()));
        rules.add(new Rules("BP_norm", "H_no", "A_old", "SM_yes", "HB_high", Perems.R_maybe_no()));
        rules.add(new Rules("BP_norm", "H_yes", "A_young_mid", "SM_yes", "HB_high", Perems.R_50()));
        rules.add(new Rules("BP_norm", "H_yes", "A_old", "SM_no", "HB_high", Perems.R_maybe_yes()));

        rules.add(new Rules("BP_norm", "H_yes", "A_old", "SM_yes", "HB_norm", Perems.R_maybe_no()));
        rules.add(new Rules("BP_high", "H_no", "A_young_mid", "SM_yes", "HB_high", Perems.R_maybe_yes()));
        rules.add(new Rules("BP_high", "H_no", "A_old", "SM_no", "HB_high", Perems.R_maybe_yes()));
        rules.add(new Rules("BP_norm", "H_no", "A_old", "SM_yes", "HB_norm", Perems.R_maybe_yes()));
        rules.add(new Rules("BP_high", "H_yes", "A_young_mid", "SM_no", "HB_high", Perems.R_maybe_yes()));

        rules.add(new Rules("BP_high", "H_yes", "A_young_mid", "SM_yes", "HB_norm", Perems.R_50()));
        rules.add(new Rules("BP_high", "H_yes", "A_old", "SM_no", "HB_norm", Perems.R_maybe_yes()));

        return rules;
    }
}
