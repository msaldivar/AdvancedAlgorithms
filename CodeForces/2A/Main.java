//package com.company;
import java.io.*;
import java.util.Hashtable;
import java.util.Map;

//@author Maurice Saldivar
public class Main
{

    public static void main(String[] args) throws IOException {
        BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);

        String[] tokens;
        int N = Integer.parseInt(aReader.readLine());
        Map<String, Integer> aMap = new Hashtable<String, Integer>();
        int max = -1000;
        int[] values = new int[N];
        String[] names = new String[N];

        for (int i = 0; i < N; i++ )
        {
            tokens = aReader.readLine().split(" ");
            String name = tokens[0];
            int points = Integer.parseInt(tokens[1]);
            Integer lookUpVal = aMap.get(name);

            if(lookUpVal != null)
                points += lookUpVal;


            values[i] = points;
            names[i] = name;
            aMap.put(name, points);
        }


        for (String key: aMap.keySet())
            if(aMap.get(key) > max)
                max = aMap.get(key);

        for(int i = 0; i < N; i++)
        {

            if(values[i] >= max && aMap.get(names[i]) == max)
            {
                aWriter.println(names[i]);
                break;
            }


        }





    }
}