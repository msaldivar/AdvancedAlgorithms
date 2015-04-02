//package com.company;
import java.io.*;

//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String eq[] = br.readLine().split("\\s+"); //employee qualifications
        int cost[] = new int[N + 1]; //have to make it index start at 1 other wise you will go out of range
        int M = Integer.parseInt(br.readLine());

        //populate with extremely large value ot be used as a comparison
        //if c is less than large value add it to my array
        for (int i = 0; i <= N; ++i) {
            cost[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; ++i) {

            String tokens[] = br.readLine().split("\\s+");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            if (c < cost[b]) {
                cost[b] = c;
            }
        }


        int sum = 0;
        int count = 0; //variable to determine if its possible to build the tree
        for (int i = 1; i <= N; ++i) {

            if (cost[i] == Integer.MAX_VALUE) {
                count++;
            } else {
                sum += cost[i];
            }
        }

        if (count == 1) {
            pr.println(sum);
            pr.flush();
        } else {            //impossible o do so print -1
            pr.println(-1);
            pr.flush();
        }
    }
}
