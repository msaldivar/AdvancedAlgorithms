//package com.company;
import java.io.*;

public class Main
{

    public static void main(String[] args) throws Exception
    {
    	try
        {
            BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter aWriter = new PrintWriter(System.out, true);
            String tokens[];
            int T = Integer.parseInt(aReader.readLine());

            for (int i = 0; i < T; ++i)
            {
                tokens = aReader.readLine().split("\\s+");
                int N = Integer.parseInt(tokens[0]);
                int K = Integer.parseInt(tokens[1]);

                //used long to help avoid a possible overflow
                long numPasses[] = new long[N + 1];
                //if 0 he could only make one pass
                numPasses[0] = 1;

                //equation was found online
                for (int j = 2; j <= N; j++)
                    numPasses[j] = ((K - 1) * numPasses[j - 1] + K * numPasses[j - 2]) % 1000000007;

                aWriter.println(numPasses[N]);


            }


        }catch (Exception e)
        {
            return;
        }
    }
}
