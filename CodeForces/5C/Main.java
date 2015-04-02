//package com.company;
import java.io.*;
import java.util.*;

//@author Maurice Saldivar


public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String tokens = br.readLine();
        int N = tokens.length();
        int longestSeq = 0;
        int count = 1;
        int startPos = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < N; ++i) {

            if (tokens.charAt(i) == '(') {
                stack.push(i);
            }else {

                if (stack.isEmpty()) {
                    startPos = i + 1;
                    continue;
                }
                stack.pop();
                if (stack.isEmpty()) {

                    if (i - startPos + 1 > longestSeq) {
                        longestSeq = i - startPos + 1;
                        count = 1;
                    }else if (i - startPos + 1 == longestSeq) {
                        count++;
                    }
                } else {

                    if (i - stack.peek() > longestSeq) {
                        longestSeq = i - stack.peek();
                        count = 1;
                    }else if (i - stack.peek() == longestSeq) {
                        count++;
                    }
                }
            }
        }

        pr.print(longestSeq + " " + count);
        pr.flush();


    }
}
