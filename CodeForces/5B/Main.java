//package com.company;
import java.io.*;
import java.util.*;
//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception{

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out,true);
            List<String> words = new ArrayList<String>();
            int maxLength = 0;
            String temp = "";
            while ((temp = br.readLine()) != null) {
                words.add(temp);
                maxLength = (maxLength < temp.length()) ? temp.length() : maxLength;

            }


            StringBuilder topAndBottom = new StringBuilder();
            //print the first row of stars
            for (int i = 0; i < maxLength + 2; i++) {
                topAndBottom.append("*");
            }
            pw.println(topAndBottom);

            boolean moveLeft = true;
            for (int i = 0; i < words.size(); ++i) {
                pw.print("*"); //border star
                int whiteSpace = maxLength - words.get(i).length();
                int leftWhiteSpace;
                int rightWhiteSpace;

                if (whiteSpace % 2 == 0) {
                    leftWhiteSpace = rightWhiteSpace = whiteSpace / 2;
                } else if (moveLeft) {
                    leftWhiteSpace = whiteSpace / 2;
                    rightWhiteSpace = whiteSpace / 2 + 1;
                    moveLeft = false;
                } else {
                    leftWhiteSpace = whiteSpace / 2 + 1;
                    rightWhiteSpace= whiteSpace / 2;
                    moveLeft = true;
                }

                for (int j = 0 ; j < leftWhiteSpace; ++j) {
                    pw.print(" ");
                }
                pw.print(words.get(i));
                for (int j = 0; j < rightWhiteSpace; ++j) {
                    pw.print(" ");
                }

                pw.print("*\n");

            }

            pw.println(topAndBottom);
            pw.close();


        }catch (Exception e) {

        }


    }
}
