//package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//@author Maurice Saldivar

class Main
{

    static final int MAX = 100001;
    static final int K_MAX = 6;

    //Sieve of Eratosthenes - builds a list of primes
    private static void SoE(int[] primeList)
    {
        primeList[0]=primeList[1]=-1;
        for (int i=2; i<primeList.length;i++)
        {
            if(primeList[i]==0)
            {
                primeList[i]=1;
                for(int j=2;j*i<primeList.length;j++)
                    primeList[i*j]++;
            }
        }
    }

    private static void fillKprime(int[] primeList, int[][] kPrimeList)
    {
        for(int i = 1; i <= 5; i++)
        {
            kPrimeList[i][0] = kPrimeList[i][1] = 0;
            for (int j = 2; j < kPrimeList[i].length; j++)
            {
                kPrimeList[i][j] = kPrimeList[i][j-1];
                if(primeList[j] == i)
                    kPrimeList[i][j] = kPrimeList[i][j] + 1;
            }
        }
    }

    public static void main(String[] args) throws Exception
    {

	    BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(aReader.readLine());
        int A, B, K;
        int primeList[] = new int[MAX];
        int kPrimeList[][] = new int[K_MAX][MAX];
        SoE(primeList);
        fillKprime(primeList, kPrimeList);
        String[] tokens;
        for (int i = 0; i < T; i++)
        {
            tokens=aReader.readLine().split(" ");
            A=Integer.parseInt(tokens[0]);
            B=Integer.parseInt(tokens[1]);
            K=Integer.parseInt(tokens[2]);

            System.out.println(kPrimeList[K][B] - kPrimeList[K][A-1]);
        }
        aReader.close();
    }
}
