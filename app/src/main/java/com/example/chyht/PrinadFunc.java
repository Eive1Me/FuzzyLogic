package com.example.chyht;

public class PrinadFunc {

    public static double left(double a, double b, int x){
        if (x<=a){
            return 1;}
        if (x>=b){
            return 0;}
        return ((double)(b-x)/(b-a));
    }

    public static double right(double a, double b, int x){
        if (x<=a)
            return 0;
        if (x>=b)
            return 1;
        return ((double)(x-a)/(b-a));
    }

//    public static double left(double a, double b, double c, int x){
//        if (x<a)
//            return 1;
//        if (x>b)
//            return 0;
//        if (x>=a && x<b)
//            return ((double) (x-a)/(b-a));
//        if (x>=b && x<=c)
//            return ((double) (c-x)/(c-b));
//        return ((double)(b-x)/(b-a));
//    }
//
//    public static double right(double a, double b, double c, int x){
//        if (x<a)
//            return 0;
//        if (x>b)
//            return 1;
//        if (x>=a && x<b)
//            return ((double) (x-a)/(b-a));
//        if (x>=b && x<=c)
//            return ((double) (c-x)/(c-b));
//        return ((double)(b-x)/(b-a));
//    }
}
