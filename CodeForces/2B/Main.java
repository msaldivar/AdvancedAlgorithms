//package com.company;
import java.io.*;
import java.util.*;
//@author Maurice Saldivar
public class Main
{

    public static void main(String[] args) throws IOException
    {
        try
        {
           // BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
            Scanner aScan = new Scanner(System.in);
            PrintWriter aWriter = new PrintWriter(System.out, true);
            String tokens[];
            int n = aScan.nextInt();

            //using 2 and 5 since a non zero is determined by the prime factor of the smallest of 2 and 5
            int[][] multOf2 = new int[n][n];
            int[][] multOf5 = new int[n][n];
            int[][] twoMin = new int[n][n];
            int[][] fiveMin = new int[n][n];

            int X0 = -1;
            int Y0 = -1;

            for (int i = 0; i < n; i++ )
            {
                for (int j = 0; j < n; j++)
                {
                    int temp = aScan.nextInt();
                    if(temp == 0)
                    {
                        multOf2[i][j] = multOf5[i][j] = 1;
                        X0 = i;
                        Y0 = j;
                    }else
                    {
                        int count = 0;
                        while (temp % 2 == 0) //counting prime fact of 2s
                        {
                            count++;
                            temp /= 2;
                        }
                        multOf2[i][j] = count;

                        count = 0;
                        while (temp % 5 == 0) //counting prime fact of 5s
                        {
                            count++;
                            temp /= 5;
                        }
                        multOf5[i][j] = count;
                    }

                }
            }


            twoMin[0][0] = multOf2[0][0];
            for (int j = 1; j < n; j++)
                twoMin[0][j] = twoMin[0][j-1] + multOf2[0][j];
            for (int i = 1; i < n; i++)
                twoMin[i][0] = twoMin[i-1][0] + multOf2[i][0];

            for (int i = 1; i < n; i++)
                for (int j = 1; j < n; j++)
                    twoMin[i][j] = Math.min(twoMin[i-1][j], twoMin[i][j-1]) + multOf2[i][j];



            // I should've put some of this into methods but I was in a hurry
            fiveMin[0][0] = multOf5[0][0];
            for (int j = 1; j < n; j++)
                fiveMin[0][j] = fiveMin[0][j-1] + multOf5[0][j];
            for (int i = 1; i < n; i++)
                fiveMin[i][0] = fiveMin[i-1][0] + multOf5[i][0];

            for (int i = 1; i < n; i++)
                for (int j = 1; j < n; j++)
                    fiveMin[i][j] = Math.min(fiveMin[i-1][j], fiveMin[i][j-1]) + multOf5[i][j];


            if (X0 < 0 || Math.min(twoMin[n-1][n-1], fiveMin[n-1][n-1]) == 0)
            {

                if (twoMin[n-1][n-1] < fiveMin[n-1][n-1])
                {
                    aWriter.println(twoMin[n-1][n-1]);

                    //working backwards so stack is best for this
                    Deque<Character> aStack = new ArrayDeque<Character>();
                    int i = n-1, j = n-1;
                    while (i != 0 || j != 0) {
                        if (i == 0) {
                            aStack.push('R');
                            j--;
                        }else if (j == 0)
                        {
                            aStack.push('D');
                            i--;
                        }
                        else
                        {
                            if (twoMin[i][j]-multOf2[i][j] == twoMin[i-1][j])
                            {
                                aStack.push('D');
                                i--;
                            }
                            else
                            {
                                aStack.push('R');
                                j--;
                            }
                        }
                    }

                    while (!aStack.isEmpty())
                    {
                        aWriter.print(aStack.pop());
                    }
                }
                else
                {
                    aWriter.println(fiveMin[n-1][n-1]);

                    //working backwards so stack is best for this
                    Deque<Character> aStack = new ArrayDeque<Character>();
                    int i = n-1, j = n-1;
                    while (i != 0 || j != 0)
                    {
                        if (i == 0)
                        {
                            aStack.push('R');
                            j--;
                        } else if (j == 0)
                        {
                            aStack.push('D');
                            i--;
                        } else
                        {
                            if (fiveMin[i][j]-multOf5[i][j] == fiveMin[i-1][j])
                            {
                                aStack.push('D');
                                i--;
                            } else {
                                aStack.push('R');
                                j--;
                            }
                        }
                    }

                    while (!aStack.isEmpty())
                    {
                        aWriter.print(aStack.pop());
                    }
                }
            }
            else
            {
                aWriter.println(1);
                for (int i = 0; i < X0; i++)
                    aWriter.print('D');
                for (int j = 0; j < Y0; j++)
                    aWriter.print('R');
                for (int i = X0; i < n-1; i++)
                    aWriter.print('D');
                for (int j = Y0; j < n-1; j++)
                    aWriter.print('R');
                aWriter.println();
            }


            aWriter.flush();
        }
        catch (Exception e)
        {
            return;
        }
    }
}
