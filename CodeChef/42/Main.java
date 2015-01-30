//package com.company;
import java.util.Scanner;
/*@author Maurice Saldivar
* */

public class Main
{

    public static void main(String[] args)
    {

	    Scanner aScanner = new Scanner(System.in);
        int var = 0;
        while((var = aScanner.nextInt()) != 42)
            System.out.println(var);

        aScanner.close();

    }
}
