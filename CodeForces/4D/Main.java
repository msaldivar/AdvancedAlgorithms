//package com.company;
import java.io.*;
import java.util.*;

//@author Maurice Saldivar
public class Main
{
    //a class so I can keep track of all the information
    public static class Envelope implements Comparable<Envelope>
    {
        int pos;
        int width;
        int height;

        public Envelope(int pos, int width, int height)
        {
            this.pos = pos;
            this.width = width;
            this.height = height;
        }

        boolean larger(Envelope e)
        {
            return width > e.width && height > e.height;
        }

        @Override
        public int compareTo(Envelope o)
        {
            if (this.width != o.width)
                return this.width - o.width;

            return this.height - o.height;
        }
    }

    public static void main(String[] args) throws Exception
    {
	    BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);
        String tokens[];

        tokens = aReader.readLine().split("\\s+");
        int N = Integer.parseInt(tokens[0]);
        int W = Integer.parseInt(tokens[1]);
        int H = Integer.parseInt(tokens[2]);
        int counter = 0;
        Envelope[] envelopes = new Envelope[N];

        for (int i = 0; i < N; ++i)
        {
            tokens = aReader.readLine().split("\\s+");
            int tempW = Integer.parseInt(tokens[0]);
            int tempH = Integer.parseInt(tokens[1]);

            //if the envelopes is larger than the the card
            if (W < tempW && H < tempH)
                envelopes[counter++] = new Envelope(i, tempW, tempH);

        }

        //base case no envelope is larger than the card
        if (counter == 0)
        {
            aWriter.println(0);
            return;
        }

        Arrays.sort(envelopes, 0, counter);

        //dynamic programming part
        int answer[] = new int[counter];
        answer[0] = 1;

        int prev[] = new int[counter];
        prev[0] = -1;


        int max = 1;
        int index = 0;
        for (int i = 1; i < counter; ++i)
        {
            prev[i] = -1;

            int localMax = 0;
            for (int j = 0; j < i; ++j)
            {
                if (envelopes[i].larger(envelopes[j]) && localMax < answer[j])
                {
                    localMax = answer[j];
                    prev[i] = j;
                }
            }

            answer[i] = localMax + 1; //taking the last index into account

            if (answer[i] > max)
            {
                max = answer[i];
                index = i;
            }

        }

        aWriter.println(max);

        //used a stack so I can back track
        Deque<Integer> aStack = new ArrayDeque<Integer>();
        aStack.push(index);
        while (prev[index] >= 0)
        {
            aStack.push(prev[index]);
            index = prev[index];
        }

        while (!aStack.isEmpty())
        {
            aWriter.print(envelopes[aStack.pop()].pos+1);
            aWriter.print(" ");
        }

        aWriter.println();

    }
}
