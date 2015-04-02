//package com.company;
import java.io.*;
//@author Maurice Saldivar
public class Main {

    //max size isn't that large so I just assign it max size
    public static long[] scores = new long[10001];
    public static int[] chefs = new int[10001];

//    public static void union (int x, int y) {
//        chefs[find(x)] = find(y);
//    }

    //modified union to increase speed
    private static void union (int x, int y) {
        int tempX = find(x);
        int tempY = find(y);
        if (scores[tempX] < scores[tempY]) {
            chefs[tempX] = tempY;
        } else if (scores[tempX] > scores[tempY]) {
            chefs[tempY] = tempX;
        } else {
            return;
        }
    }

    //iterative for path compression so it doesn't crash
    private static int find(int x) {
        int tempX = x;
        while(tempX != chefs[tempX]) {
            tempX = chefs[tempX];
            chefs[tempX] = chefs[chefs[tempX]];
        }
        chefs[x] = tempX;
        return chefs[x];
    }




    public static void main(String[] args) throws IOException{


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out);
            int T = Integer.parseInt(br.readLine());

            while (T-->0){

                int N = Integer.parseInt(br.readLine());
                String []tokens = br.readLine().split("\\s+");
                for (int i = 0; i < N; ++i) {
                    chefs[i] = i;
                    scores[i] = Integer.parseInt(tokens[i]);
                }

                int Q = Integer.parseInt(br.readLine());
                for (int i = 0; i < Q; ++i) {
                    tokens = br.readLine().split("\\s+");
                    if (tokens[0].equals("1")) {
                        pw.println(find(Integer.parseInt(tokens[1]) - 1) + 1);
                    } else {

                        int chef1 = find(Integer.parseInt(tokens[1]) - 1);
                        int chef2 = find(Integer.parseInt(tokens[2]) - 1);

                        if (chef1 == chef2) {
                            pw.println("Invalid query!");
                        } else {
                            union(chef1, chef2);
                        }
                    }
                }
            }
            pw.flush();


    }

}
