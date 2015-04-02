//package com.company;
import java.io.*;

//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String tokens [] = br.readLine().split("\\s+");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);
        long dp[][] = new long[N + 1][K + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= N; ++i ) {

            for (int j = 0; j <= Math.min(i,K); ++j) { //slight optimization on search if it meets tree requirements

                for (int m = 1; m <= i; ++m) {

                    if (j == 0) { //just a special case to handle
                        dp[i][j] += dp[m - 1][0] * dp[i - m][0];
                    }else {

                        dp[i][j] += dp[m - 1][0] * dp[i - m][j - 1]; //add one child tree
                        dp[i][j] += dp[m - 1][j - 1] * dp[i - m][0]; //add other child tree
                        dp[i][j] -= dp[m - 1][j - 1] * dp[i - m][j - 1]; //remove double counted items
                    }
                }
            }
        }

        pr.println(dp[N][K]);
        pr.flush();
    }
}
