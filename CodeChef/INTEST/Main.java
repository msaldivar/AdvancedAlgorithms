//package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/*@Author Maurice Saldivar*/


public class Main
{

    public static void main(String[] args) throws Exception{

	    BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        String lineOne = aReader.readLine();
        String[] tokens = lineOne.split("[ ]+");

        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        int temp = 0;
        int counter = 0;
        for (int i = 0; i < n; i++)
        {
            temp = Integer.parseInt(aReader.readLine());
            if(temp % k == 0) counter++;
        }
        aReader.close();
        System.out.println(counter);
    }
}
