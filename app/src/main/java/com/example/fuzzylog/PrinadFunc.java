package com.example.fuzzylog;

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

    public static double triangular(double a, double b, double c, int x){
        return Math.max(Math.min((x-a)/(b-a),(c-x)/(c-b)),0);
    }

    public static double middle(double a, double b, double c, double d, int x)
    {
        if (a <= x && x <= b)
            return 1 - (b - x) / (b - a);
        if (b <= x && x <= c)
            return 1;
        if (c <= x && x <= d)
            return 1 - (x - c) / (d - c);
        return 0;
    }
}
