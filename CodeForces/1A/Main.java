//package com.company;
import java.util.Scanner;
/*@Author Maurice Saldivar
* */

public class Main
{

    public static void main(String[] args)
    {
        Scanner aScanner = new Scanner(System.in);
        double n = aScanner.nextInt();
        double m = aScanner.nextInt();
        double a = aScanner.nextInt();


        int lenRatio = (int)Math.ceil(n/a);
        int widthRatio = (int)Math.ceil(m/a);

        System.out.println((long)lenRatio*widthRatio);
        aScanner.close();

    }
}
