package com.example.chyht;

public class Perems {

    public static double BP_norm(int x){
        return PrinadFunc.left(130,140,x);
    }

    public static double BP_high(int x){
        return PrinadFunc.right(130,140,x);
    }

    public static double H_yes(int x){
        return PrinadFunc.right(0.1,0.9,x);
    }

    public static double H_no(int x){
        return PrinadFunc.left(0.1,0.9,x);
    }

    public static double A_young_mid(int x){
        return PrinadFunc.left(53,57,x);
    }

    public static double A_old(int x){
        return PrinadFunc.right(53,57,x);
    }

    public static double SM_yes(int x){
        return PrinadFunc.right(0.1,0.9,x);
    }

    public static double SM_no(int x){
        return PrinadFunc.left(0.1,0.9,x);
    }

    public static double HB_norm(int x){
        return PrinadFunc.left(80,90,x);
    }

    public static double HB_high(int x){ return PrinadFunc.right(80,90,x); }

    public static double R_no(){
        return 0;
    }
    public static double R_maybe_no(){
        return 1;
    }
    public static double R_50(){
        return 2;
    }
    public static double R_maybe_yes(){
        return 3;
    }
    public static double R_yes(){
        return 4;
    }



}
