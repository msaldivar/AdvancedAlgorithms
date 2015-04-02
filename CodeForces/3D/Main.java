//package com.company;
import java.io.*;
import java.util.*;

//@author Maurice Saldivar
public class Main
{
    private static class Cost implements Comparable<Cost>
    {
        int cost;
        int position;

        public Cost(int cost, int position)
        {
            this.cost = cost;
            this.position = position;

        }

        @Override
        public int compareTo(Cost o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }



    public static void main(String[] args) throws IOException{
	    BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);
        StringBuilder tokens = new StringBuilder(aReader.readLine());

        long isBalanced = 0;
        long score = 0;
        //queue is used to make symbol table to make sure everything matches
        Queue<Cost> balanceTable = new PriorityQueue<Cost>();
        String prices[] = new String[2];
        for (int i = 0; i < tokens.length(); i++)
        {
            if(tokens.charAt(i) == '(')
                isBalanced++;
            else if(tokens.charAt(i) == ')')
                isBalanced--;
            else if(tokens.charAt(i) == '?')
            {
                prices = aReader.readLine().split(" ");
                tokens.setCharAt(i, ')');
                int val = Integer.parseInt(prices[0]) - Integer.parseInt(prices[1]);
                balanceTable.add(new Cost(val, i));
                score += Integer.parseInt(prices[1]);
                isBalanced--;
            }

            if(!balanceTable.isEmpty() && isBalanced == -1)
            {
                Cost temp = balanceTable.poll();
                tokens.setCharAt(temp.position, '(');
                score += temp.cost;

                isBalanced += 2;
            }else if(isBalanced < -1)
                break;
        }

        if(isBalanced == 0)
        {
            aWriter.println(score);
            aWriter.println(tokens);
        }else
            aWriter.println(-1);




    }
}
