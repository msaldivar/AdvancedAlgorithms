//package com.company;
import java.io.*;
//@author Maurice Saldivar


public class Main {

    //max size isn't that large so I reserve the max memory
    public static int locations[] = new int[101];
    public static int fastRoads[] = new int[101];

    //modified union to increase speed
    private static void union (int x, int y) {
        int tempX = find(x);
        int tempY = find(y);

        if (tempX == tempY) {
            return;
        } else if (fastRoads[tempX] < fastRoads[tempY]) {
            locations[tempX] = tempY;
        } else {
            locations[tempY] = tempX;
        }

    }

//    //path compression using recursion
//    private static int find (int x) {
//        if (locations[x] != locations[locations[x]]) {
//            locations[x] = find(locations[x]);
//        }
//        return locations[x];
//    }

//    private static int find (int x) {
//
//        if (locations[x] == x) {
//            return x;
//        }
//        locations[x] = find(locations[x]);
//        return locations[x];
//
//    }


    //iterative for path compression so it doesn't crash
    private static int find(int x) {
        while(locations[x] != x) {
            locations[x] = locations[locations[x]];
            x = locations[x];
        }
        return x;
    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());

        while (T-->0){

            String tokens[] = br.readLine().split("\\s+");
            int N = Integer.parseInt(tokens[0]);
            int M = Integer.parseInt(tokens[1]);

            for (int i = 0; i < N; ++i) {
                locations[i] = i;
            }

            for (int i = 0; i < M; ++i) {
                tokens = br.readLine().split("\\s+");
                union(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
            }

            int Q = Integer.parseInt(br.readLine());
            for (int i = 0; i < Q; ++i) {
                tokens = br.readLine().split("\\s+");
                int A = Integer.parseInt(tokens[0]);
                int B = Integer.parseInt(tokens[1]);

                if (find(A) != find(B)) {
                    pw.println("NO");
                } else {
                    pw.println("YO");
                }
            }
        }
        pw.flush();
    }
}
