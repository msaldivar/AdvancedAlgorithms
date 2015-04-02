//package com.company;
import java.io.*;

//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String tokens[];
        tokens = br.readLine().split("\\s+");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        int V = Integer.parseInt(tokens[2]);
        long conntectID = (long)(N - 1) * (N - 2) / 2 + 1;
        //instead of using a list or matrix I use a string builder
        //based on the conditions determines if I append the value or not
        StringBuilder sb = new StringBuilder();

        if (M >= N - 1 && M <= conntectID) {

            for (int i = 1; i <= N; ++i) {

                if (i != V) {
                    sb.append(i + " " + V + "\n");
                }
            }

            M -= N -1;

            for (int i = 1; M > 0; ++i) {

                if (i != V) {

                    for (int j = 1; j < i && M > 0; ++j) {

                        if (j != V) {
                            sb.append(j + " " + i + "\n");
                            M--;
                        }
                    }
                }
            }

            pr.println(sb);

        } else {
            pr.println("-1");
        }

        pr.flush();
    }
}
