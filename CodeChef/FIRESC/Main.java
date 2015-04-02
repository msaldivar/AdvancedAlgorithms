package com.company;
import java.io.*;
//@author Maurice Saldivar

public class Main
{
    static int [] uf;

    // //path compression for faster find
    // private static int find (int x) {
    //     if (uf[x] != uf[uf[x]]) {
    //         uf[x] = find(uf[x]);
    //     }
    //     return uf[x];
    // }

    // private static int find (int x) {
    //     if (uf[x] == x) {
    //         return x;
    //     }
    //     return uf[x] = find(uf[x]);
    // }

    //iterative for path compression so it doesn't crash
    private static int find(int x) {
        while(uf[x] != x) {
            uf[x] = uf[uf[x]];
            x = uf[x];
        }
        return x;
    }

    private static void union (int x, int y) {
        uf[find(x)] = find(y);
    }



    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        String tokens[];
        int T = Integer.parseInt(br.readLine());


        for(int i = 0; i < T; ++i) {

            tokens = br.readLine().split("\\s+");

            int N = Integer.parseInt(tokens[0]);
            int M = Integer.parseInt(tokens[1]);
            uf = new int[N];

            for(int j = 0; j < N; ++j) {
                uf[j]=j;
            }


            for(int j = 0; j < M; ++j) {

                tokens = br.readLine().split("\\s+");
                int X = Integer.parseInt(tokens[0]);
                int Y = Integer.parseInt(tokens[1]);
                //minus 1 since arrays start at 0
                union(X - 1, Y - 1);
            }

            long answer = 1;
            int max = 0;
            int employeeSize[] = new int[N ];

            for(int j = 0; j < N; j++)
            {
                int index = find(j);
                employeeSize[index]++;
            }

            for(int j = 0; j < N; ++j)
            {
                if(employeeSize[j]>0)
                {
                    max++;
                    answer = answer * employeeSize[j] % 1000000007;
                }
            }

            pw.println(max + " " + answer);

        }


    }
}
