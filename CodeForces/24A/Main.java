//package com.company;
import java.io.*;
import java.util.Arrays;

//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String tokens[];
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int cost = 0;
        //like discussed in class I use two different arrays to keep track of the information and use greedy approach
        int A[] = new int[n + 1];
        int B[] = new int[n + 1];
        Arrays.fill(A, -1);
        Arrays.fill(B, -1);

        for (int i = 0; i < n; ++i) {

            tokens = br.readLine().split("\\s+");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            if (A[a] == -1 && B[b] == -1) {

                A[a] = b;
                B[b] = a;
                cost += c;
            }else {

                A[b] = a;
                B[a] = b;
            }

            sum += c;
        }

        if (cost < sum - cost) {
            pr.println(cost);
        }else {
            pr.println(sum - cost);
        }

        pr.flush();
    }
}
