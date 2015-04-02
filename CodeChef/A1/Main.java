package com.company;
import java.io.*;

//@author Maurice Saldivar
//this is my same code as PPTEST with a simple change to fit the problem statement
public class Main
{
    public static int answer[][];

    private static void knapSack(int[] benefit, int[] cost, int n, int w )
    {
        //use knapsack algorithm to solve this.
        answer = new int[n + 1][w + 1];

        //I really don't need this two loops
        //but it's easier for me to envision if I populate them with 0
        for(int i = 0; i <= n; i++)
            answer[i][0] = 0;
        for(int i = 0; i <=  w; i++)
            answer[0][i] = 0;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= w; j++)
            {
                if(cost[i - 1] <= j)
                    answer[i][j] = Math.max(benefit[i - 1]+answer[i - 1][j - cost[i - 1]], answer[i - 1][j]);
                else
                    answer[i][j] = answer[i - 1][j];
            }
        }
    }

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
                tokens = aReader.readLine().split(" ");
                int n = Integer.parseInt(tokens[0]);
                int w = Integer.parseInt(tokens[1]);
                int benefit[] = new int[n];
                int cost[] = new int[n];

                //benefit and cost are the same and I'm just seeing if the max found is equal to w
                for (int j = 0; j < n; j++)
                {
                    tokens = aReader.readLine().split(" ");
                    benefit[j] = Integer.parseInt(tokens[0]);
                    cost[j] = Integer.parseInt(tokens[0]);
                }
                knapSack(benefit, cost, n, w);
                boolean isMatch = false;
                if(isMatch = (answer[n][w] == w) ? true : false)
                    aWriter.println("Yes");
                else
                    aWriter.println("No");
            }
        }
        catch (Exception e)
        {
            return;
        }
    }
}
