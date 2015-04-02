//package com.company;
import java.io.*;
//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out, true);
            String tokens[];
            int numBars = Integer.parseInt(br.readLine());
            int bars[] = new int[numBars];
            tokens = br.readLine().split("\\s+");

            //putting everything into an int array to make the code easier to read
            for (int i = 0; i < numBars; ++i) {
                bars[i] = Integer.parseInt(tokens[i]);
            }

            int alice = 0; //starting spot
            int bob = bars.length - 1; // ending spot
            int aCounter = 0;
            int bCounter = 0;
            boolean flag = true;

            //I keep moving the number towards each other.
            //whoever has min I ++ a counter for them
            //once the numbers land on top of each other I quite
            for (int i = 0; i < numBars; ++i) {

                int temp = 0;
                temp = Math.min(bars[alice], bars[bob]);
                if (alice == bob) {
                    if (flag) {
                        aCounter++;
                        break;
                    } else {
                        bCounter++;
                        break;
                    }
                }

                if (temp == bars[alice]) {
                    aCounter++;
                    bars[bob] -= bars[alice];
                    bars[alice] -= bars[alice];
                    alice = (bars[alice] == 0) ? alice + 1 : alice;
                    flag = false;
                } else {
                    bCounter++;
                    bars[alice] -= bars[bob];
                    bars[bob] -= bars[bob];
                    bob = (bars[bob] == 0) ? bob - 1 : bob;
                    flag = true;
                }

            }

            pw.println(aCounter + " " + bCounter);

        }catch (Exception e) {

        }


    }
}
