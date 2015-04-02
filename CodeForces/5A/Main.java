//package com.company;
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out, true);
        HashSet<String> hash = new HashSet<String>();
        String tokens;
        int answer = 0;

        while ((tokens = br.readLine()) != null && !tokens.equals("")) {

            if (tokens.charAt(0) == '+') {
                hash.add(tokens.substring(1));
            } else if (tokens.charAt(0) == '-') {
                hash.remove(tokens.substring(1));
            }else {
                String temp[] = tokens.split(":");
                if (temp.length == 2) {
                    answer += temp[1].length() * hash.size();

                }
            }
        }
        pr.println(answer);
    }
}
