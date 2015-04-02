//package com.company;
import java.io.*;
//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 0 && N != 2) {
            pr.println("YES");
            pr.flush();
        }else {
            pr.println("NO");
            pr.flush();
        }



    }
}
