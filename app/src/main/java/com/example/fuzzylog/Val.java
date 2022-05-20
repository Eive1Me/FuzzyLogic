package com.example.fuzzylog;

public class Val {

    public static double Temp_cold(int x){
        return MemberFunction.left(10,25,x);
    }

    public static double Temp_medium(int x){
        return MemberFunction.triangular(15,25,35,x);
    }

    public static double Temp_hot(int x){
        return MemberFunction.right(25,40,x);
    }

    public static double Humid_dry(int x){
        return MemberFunction.left(0,60,x);
    }

    public static double Humid_normal(int x){
        return MemberFunction.middle(30,60, 75, 90,x);
    }

    public static double Humid_wet(int x){
        return MemberFunction.right(60,100,x);
    }

    public static double R_slow(){
        return 0;
    }
    public static double R_moderate(){
        return 1;
    }
    public static double R_fast(){
        return 2;
    }

}
