package com.company;
import java.io.*;

//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String tokens[];
        int N = Integer.parseInt(br.readLine());
        tokens = br.readLine().split("\\s");
        int hillH[] = new int[tokens.length];
        int counter = 0;
        boolean flag = false;
        for (int i = 0; i < hillH.length; ++i) {
            hillH[i] = Integer.parseInt(tokens[i]);
        }

        for (int i = 0; i < hillH.length; ++i) {

            for (int j = i + 1; j < hillH.length; ++j) {

                if (hillH[i] <= hillH[j] && hillH[j] >= hillH[j - 1] ) {
                    counter++;
                    if (hillH[i] == hillH[j]) {
                        flag = true;
                    }else {
                        flag = false;
                    }
                }
            }
        }
        if (flag) {
            pr.println(counter);
            pr.flush();
        }else {
            pr.println(counter + 1);
            pr.flush();
        }
    }
}
