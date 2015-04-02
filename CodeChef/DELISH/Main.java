package com.company;
import java.io.*;

//@author Maurice Saldivar

public class Main
{


    public static void main(String[] args) throws Exception
    {
        try
        {
            BufferedReader aReader = new BufferedReader( new InputStreamReader(System.in));
            PrintWriter aWriter = new PrintWriter(System.out, true);
            String tokens[];
            int T = Integer.parseInt(aReader.readLine());
            //used long to prevent possible overflow
            //left stores max and min from left till i
            //right stores max and min from right till i
            long left[][] = new long[1000004][2];
            long right[][] = new long[1000004][2];



            for (int i = 0; i < T; i++)
            {
                int N = Integer.parseInt(aReader.readLine());
                tokens = aReader.readLine().split("\\s+");

                left[0][0] = Integer.parseInt(tokens[0]);
                left[0][1] = Integer.parseInt(tokens[0]);

                for (int j = 1; j < N; j++)
                {
                    left[j][0] = Math.max(left[j-1][0], 0) + Integer.parseInt(tokens[j]);
                    left[j][1] = Math.min(left[j-1][1], 0) + Integer.parseInt(tokens[j]);
                }

                right[N-1][0] = Integer.parseInt(tokens[N-1]);
                right[N-1][1] = Integer.parseInt(tokens[N-1]);
                for (int k = N-2; k >= 0; k--)
                {
                    right[k][0] = Math.max(right[k+1][0], 0) + Integer.parseInt(tokens[k]);
                    right[k][1] = Math.min(right[k+1][1],0) + Integer.parseInt(tokens[k]);
                }

                long answer = 0;
                for (int l = 0; l < N-1; l++)
                {
                    answer = Math.max(answer,Math.abs(left[l][0] - right[l+1][1]));
                    answer = Math.max(answer, Math.abs(left[l][1] - right[l+1][0]));
                }

                aWriter.println(answer);


            }

        }
        catch (Exception e)
        {
            return;
        }
    }
}
