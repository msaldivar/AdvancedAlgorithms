//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//@author Maurice Saldivar
public class Main
{
    private static void populateNewWords(int[] newWords, int[] word, int N)
    {
        //populate to later be used for a compare
        for (int i = 0; i < N; i++)
            word[i] = i;

        //populate the newWords first even than odd
        for (int i = 0; i < N/2; i++)
            newWords[i] = i * 2 + 1;

        for(int i = 0; i < N - (N/2); i++)
            newWords[N/2 + i] = i * 2;
    }

    private static long counter(int[] newWords, int[] word, int N)
    {
        for(int i = 0; i < N; i++)
        {
            if (word[i] == newWords[i])
                continue;

            int j = i;
            //using a lexicographic order to find each cycle.
            while (word[j] != newWords[j])
            {
                //swap method
                int swap = newWords[j];
                newWords[j] = word[j];
                word[swap] = newWords[j];
                j = swap;

            }
        }

        int count = 0;
        for(int i = 0; i < N; i++)
        {
            if(word[i] == i)
                count++;
        }

        long answer = 1;
        for(int i = 0; i < count; i++)
            answer = (answer * 26) % 1000000007;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);

        String[] tokens = aReader.readLine().split(" ");
        int T = Integer.parseInt(tokens[0]);

        long result = 0;
        for(int i = 0; i < T; i++)
        {
            int N = Integer.parseInt(aReader.readLine());
            int[] word = new int[N ];
            int[] newWords = new int[N];
            populateNewWords(newWords, word, N);
            result = counter(newWords, word, N);
            aWriter.println(result);

        }
    }
}
