package com.company;
import java.io.*;
//@author Maurice Saldivar


public class Main
{

    private static int findMaxScore (int judgeLoc[][], int n)
    {
        int answer[][] = new int[n][n];
        answer[0][0] = judgeLoc[0][0];
        //these loops takes the prev slot and adds it to the current
        //so I know the final values for going all the way right and all the way down
        for (int i = 1; i < n; ++i)
            answer[i][0] = answer[i - 1][0] + judgeLoc[i][0];

        for (int i = 1; i < n; ++i)
            answer[0][i] = answer[0][i - 1] + judgeLoc[0][i];


        for (int i = 1; i < n; ++i)
        {
            for (int j = 1; j < n; ++j)
            {
                int prev = judgeLoc[i][j];
                answer[i][j] = Math.max(answer[i - 1][j], answer[i][j - 1]) + prev;
            }
        }

        return answer[n-1][n-1];

    }
    public static void main(String[] args) throws Exception
    {
	    try
        {
            BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter aWriter = new PrintWriter(System.out, true);
            String tokens[];

            int t = Integer.parseInt(aReader.readLine());

            for (int i = 0; i < t; ++i)
            {
                int n = Integer.parseInt(aReader.readLine());
                int judgeLoc[][] = new  int[n][n];

                for (int x = 0; x < n; ++x)
                {
                    tokens = aReader.readLine().split("\\s+");
                    for (int y = 0; y < n; ++y)
                    {
                        int tempLoc = 0;
                        tempLoc = Integer.parseInt(tokens[y]);
                        judgeLoc[x][y] = tempLoc;
                    }
                }

                double totalSteps = 2 * n - 3;
                double maxScore = findMaxScore(judgeLoc, n);
                if(maxScore >= 0)
                    aWriter.printf("%.6f%n",maxScore/totalSteps);
                else
                    aWriter.println("Bad Judges");


            }


        }
        catch (Exception e)
        {
            return;
        }


    }
}
