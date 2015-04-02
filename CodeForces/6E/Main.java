//package com.company;
import java.io.*;
import java.util.*;
//@author Maurice Saldivar

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        String tokens[] = br.readLine().split("\\s+");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);
        tokens = br.readLine().split("\\s+");
        SortedMap <Integer, Integer> segmentTree = new TreeMap<Integer, Integer>(); //data structure recommend in class
        int a = 0; //max books
        int b = 0; // time periods
        int startIndex = 0;
        int endIndex = 0;

        //used to keep hold of my ranges
        //like in a segment tree every node has its range and sum
        //this is the same idea only didn't implement everything as one
        List<Integer> aList = new ArrayList<Integer>();


        for (;endIndex < N;) {

            segmentTree.put(Integer.parseInt(tokens[endIndex]), segmentTree.getOrDefault(Integer.parseInt(tokens[endIndex]), 0) + 1);
            ++endIndex;

            //check if the available numbers is greater than K
            //if the value is 1 remove it from my tree
            //otherwise it must appear more than once and add it and reduce value by 1
            while (segmentTree.lastKey() - segmentTree.firstKey() > K) {

                int value = segmentTree.get(Integer.parseInt(tokens[startIndex]));
                if (value == 1) {
                    segmentTree.remove(Integer.parseInt(tokens[startIndex]));
                } else {
                    segmentTree.put(Integer.parseInt(tokens[startIndex]), value - 1);
                }
                ++startIndex;
            }

            //the reason to clear the list is because of a special case
            //the else if handles the case where no two books are less than K
            //so you would need to accept all the books.
            //if there are pairs of books that are less than K
            //clear the list of the default index values and add the start-end of the pairs less than K
            if (endIndex - startIndex > a) {
                a = endIndex - startIndex;
                aList.clear();
                aList.add(startIndex + 1);
                aList.add(endIndex);
                b = 1;
            } else if (endIndex - startIndex == a) {
                aList.add(startIndex + 1);
                aList.add(endIndex);
                ++b;
            }
        }

        pw.println(a + " " + b);
        for (int i = 1; i < aList.size(); i += 2) {
            pw.println(aList.get(i - 1) + " " + aList.get(i));
        }


        pw.flush();
    }
}
