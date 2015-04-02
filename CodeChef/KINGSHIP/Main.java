//package com.company;
import java.io.*;
import java.util.Arrays;
//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out, true);
            String tokens[];
            int T = Integer.parseInt(br.readLine());
            long minCost[];

            for (int i = 0; i < T; ++i) {

                int N = Integer.parseInt(br.readLine());
                minCost = new long[N];

                tokens = br.readLine().split("\\s+");
                for (int j = 0; j < N; ++j) {
                    minCost[j] = Integer.parseInt(tokens[j]);
                }

                Arrays.sort(minCost);
                if (minCost.length == 1) {
                    pw.println(minCost[0]);
                } else if (minCost.length == 2) {
                    pw.println(minCost[0] * minCost[1]);
                }else {
                    long mult = minCost[0];
                    long sum = 0;

                    for (int k = 1; k < minCost.length; ++k) {
                        sum = mult * minCost[k] + sum;
                    }

                    pw.println(sum);
                }




            }







        }catch (Exception e) {
            return;
        }
    }
}
