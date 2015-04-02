package com.company;
import java.io.*;

//@author Maurice Saldivar
//modified knapsack, taking a look at ending times
public class Main
{
    public static final int MAX = 48;
    public static int comp[][] = new int[MAX + 1][MAX + 1]; // max possible test cases


    public static void main(String[] args) throws IOException
    {
        try
        {
            BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter aWriter = new PrintWriter(System.out, true);
            String tokens[];

            int t = Integer.parseInt(aReader.readLine());

            //knapsack problem benefit and cost
            for (int i = 0; i < t; i++)
            {

                for (int start = 0; start <= MAX; start++)
                    for (int end = 0; end <= MAX; end++)
                        comp[start][end] = 0;

                tokens = aReader.readLine().split(" ");
                int n = Integer.parseInt(tokens[0]);

                for (int j = 0; j < n; j++)
                {
                    tokens = aReader.readLine().split(" ");
                    int Si = Integer.parseInt(tokens[0]);
                    int Ei = Integer.parseInt(tokens[1]);
                    int Ci = Integer.parseInt(tokens[2]);
                    comp[Si][Ei] = Math.max(comp[Si][Ei], Ci);
                }

                int maxComp[] = new int[MAX + 1];
                maxComp[0] = 0;
                for (int end = 1; end <= MAX; end++)
                {
                    maxComp[end] = 0;
                    for (int start = 0; start < end; start++)
                    {
                        maxComp[end] = Math.max(maxComp[end], maxComp[start] + comp[start][end]);
                    }
                }
                aWriter.println(maxComp[MAX]);
            }
        }
        catch (Exception e)
        {
            return;
        }
    }
}
