//package com.company;
import java.io.*;
import java.util.*;
//@author Maurice Saldivar



public class Main {

    static class node
    {
        char val;
        int count;
        int index;
        public node( int count, int index)
        {
            this.count=count;
            this.index=index;
        }

    }


    public static void main(String args[]) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        char numList[] = br.readLine().toCharArray();
        boolean visited[] = new boolean[10];

        //structure for my graph
        LinkedList<node> queue = new LinkedList();

        node n = new node(0,0);
        queue.add(n);

        int answer = 0;

        while(!queue.isEmpty())
        {
            node temp=queue.remove();

            //base case
            if(temp.index == numList.length-1)
            {
                answer = temp.count;
                break;
            }


            if(visited[numList[temp.index] - 48] == false)
            {
                for(int i = 0; i < numList.length; ++i)
                {
                    if(numList[i] == numList[temp.index])
                    {
                        queue.add(new node(temp.count + 1,i));
                    }
                }
                visited[numList[temp.index] - 48]=true;


            }

            if(temp.index > 0 && visited[numList[temp.index - 1] - 48] == false)
            {
                queue.add(new node(temp.count + 1, temp.index - 1));

            }
            if(temp.index + 1 < numList.length&&visited[numList[temp.index + 1] - 48] == false)
            {
                queue.add(new node(temp.count + 1, temp.index + 1));

            }

        }

        pr.println(answer);
        pr.flush();

    }
}

