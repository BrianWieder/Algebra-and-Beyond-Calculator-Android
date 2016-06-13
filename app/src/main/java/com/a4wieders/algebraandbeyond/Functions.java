package com.a4wieders.algebraandbeyond;

import android.util.Log;

import static java.lang.Math.sqrt;

/**
 * Created by brian on 6/12/2016.
 */
public class Functions {
    public static String GCF(double x, double xDivThird, double firstCoeffient, double thirdCoeffient){
        double x2 = x;

        double xDivThird2 = xDivThird;
        double firstCoeffient2 = firstCoeffient;
        double thirdCoeffient2 = thirdCoeffient;
        int y1 = 1;

        Log.e("Debug", "x2: " + x2);

        while(x2 > 0){
            double temp = x2;
            x2 = -firstCoeffient2 % x2;
            x2 = -firstCoeffient2 % x2;

            if(x2 != 0){
                x2 = firstCoeffient2 % x2;
                firstCoeffient2 = temp;
            }

            if(y1 >= 2000){
                return cant();
            }
            if(firstCoeffient2 > 0){
                y1 +=1;
            }else{
                y1 -=1;
            }
        }

        int y2 = 1;

        while(thirdCoeffient2 > 0){
            double temp = thirdCoeffient2;

            thirdCoeffient2 = xDivThird2 % thirdCoeffient2;
            thirdCoeffient2 = -xDivThird2 % thirdCoeffient2;

            if(thirdCoeffient2 != 0)
            {
                thirdCoeffient2 = xDivThird2 % thirdCoeffient2;
                xDivThird2 = temp;
            }

            if(y2 >= 2000){
                return cant();
            }

            y2++;
        }
        return Factoring(firstCoeffient, x, xDivThird, thirdCoeffient, firstCoeffient2, xDivThird2);
    }

    public static String Factoring(double a, double b, double c, double d, double x, double y){
        final double a2 = a / x;
        final double b2 = b / x;
        final double c2 = c / y;
        final double d2 = d / y;
        final String first = "("+x+"x + "+y+")";
        final String second = "("+a2+"x + " + b2 +")";
        final String third = "("+c2+"x + " + d2 + ")";
        if(second.equals(third)){
            return first + second;
        }else{
            return cant();
        }
    }

    private static String cant(){

        return "Can't find a solution";
    }

    public static String BinomialFactoring(double x, double constant){
        return"("+sqrt(x)+"x + "+sqrt(constant) +")("+sqrt(x)+"x - "+sqrt(constant)+")\nAlways check to make sure that the outputing factors are in simplest form";
    }
}
