//package com.company;
import java.io.*;
import java.util.*;
//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);


        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> database = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (database.containsKey(name)) {
                // Make up a new username and append
                pr.print(name);
                pr.println(database.get(name));
                database.put(name, database.get(name)+1);
            } else {
                pr.println("OK");
                database.put(name, 1);
            }
        }
        pr.flush();
    }

}
