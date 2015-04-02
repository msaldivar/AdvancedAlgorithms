///package com.company;
import java.io.*;
//@author Maurice Saldivar

public class Main {

    public static void main(String[] args) throws Exception {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out, true);
            String word = br.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            //first z-algorithm part. Take the string and reverse it
            sb.append(new StringBuilder(word).reverse());
            int zBox[] = new int[sb.length()];
            int left = 0;
            int right = 0;

            //z algorithm implementation
            for (int i = 1; i < sb.length(); ++i) {

                if (zBox[ i - left] < right - i && i < right) {
                    zBox[i] = zBox[i - 1];
                } else {

                    if (right >= i) {
                        left = i;
                    } else {
                        left = i;
                        right = i;
                    }

                    while (right < sb.length() && sb.charAt(right) == sb.charAt(right-left)) {
                        ++right;
                    }

                    zBox[i] = right - left;

                }
            }

            //compute the total degrees for the pal
            int totalDegrees[] = new int[sb.length() / 2 + 1];
            int max = 0;
            for (int i = 1; i < sb.length() / 2 + 1; ++i) {
                if (zBox[sb.length() - i] == i) {
                    totalDegrees[i] = totalDegrees[i / 2] + 1;
                    max += totalDegrees[i];
                }
            }

            pw.println(max);
            pw.close();

        } catch (Exception e) {

        }


    }





}
