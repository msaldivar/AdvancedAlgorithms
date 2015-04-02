//package com.company;
import java.io.*;
//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out, true);
            String tokens[];
            tokens = br.readLine().split("\\s+");
            int days = Integer.parseInt(tokens[0]);
            int sumTime = Integer.parseInt(tokens[1]);
            int minTime[] = new int[days];
            int maxTime[] = new int[days];
            for (int i = 0; i < days; ++i) {
                tokens = br.readLine().split("\\s+");
                minTime[i] = Integer.parseInt(tokens[0]);
                maxTime[i] = Integer.parseInt(tokens[1]);
            }

            //use these to see if it's even possible to study the amount of time give
            int minTimeTotal = 0;
            int maxTimeTotal = 0;
            for (int i = 0; i < days; ++i) {
                minTimeTotal += minTime[i];
                maxTimeTotal += maxTime[i];
            }

            //check if it's even possible
            if(minTimeTotal <= sumTime && sumTime <= maxTimeTotal) {
                pw.println("YES");
                int answer = 0;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < days; ++i) {

                    answer = Math.min(minTime[i] + sumTime - minTimeTotal, maxTime[i]);
                    sb.append(answer + " ");
                    sumTime -= (answer - minTime[i]);
                }
                pw.println(sb);

            }else {
                pw.println("NO");
            }


        }catch (Exception e) {

        }


    }
}
