//package com.company;
import java.io.*;

//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String tokens[];
        int n = Integer.parseInt(br.readLine());
        int students[] = new int[n];
        tokens = br.readLine().split("");
        students[0] = 1;

        for (int i = 1; i < n; ++i) {

            if (tokens[i - 1].equals("L")) {
                students[i] = 1;
            } else if (tokens[i - 1].equals("R")) {
                students[i] = students[i - 1] + 1;
            } else {
                students[i] = students[i - 1];
            }

        }

        for (int i = n - 2; i >= 0; --i) {

            if (tokens[i].equals("L")) {
                students[i] = Math.max(students[i], students[i + 1] + 1);
            } else  if (tokens[i].equals("=")) {
                students[i] = students[i + 1];
            }
        }

        for (int i = 0; i < n ; ++i) {
            pr.print(students[i] + " ");
        }
        pr.flush();
    }
}
