//package com.company;
import java.io.*;

//@author Maurice Saldivar
public class Main
{
    static int knightX = 0;
    static int knightY = 0;
    static int superMax = 0;

    private static void buildGB(int[][] gb, int n, BufferedReader aReader, String tokens) throws IOException
    {
        try
        {
            //I make everything ints so its easy to do math later on
            //knight is just -1 so its a distinct value in my gb
            for (int i = 1; i <= n; i++)
            {
                tokens = aReader.readLine();
                for (int j = 0; j < n; j++)
                {
                    if (tokens.charAt(j) == '.')
                    {
                        gb[i][j+1] = 0;
                    } else if (tokens.charAt(j) == 'P')
                    {
                        gb[i][j+1] = 1;
                    } else if (tokens.charAt(j) == 'K')
                    {
                        gb[i][j+1] = 2;
                    }
                }
            }
        }catch (Exception e)
        {
            return;
        }
    }

    private static void updateGB(int[][] gb, int n)
    {
        //starting from the right side I work my way to the kings position.
        //as I go I calculate a max for the four possible moves. I take those four and find the max out of them
        //add the biggest max to the board location. This is the number of pawns taken if I go through that point
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int max4 = 0;
        int col = 0;
        int row = 0;
        boolean done = false;

        for(col = n; col >= 1; col--)
        {
            for(row = n; row >= 1; row--)
            {
                if(gb[row][col] == 2) done = true;

                if(row - 2 > 0 && col + 1 <= n)
                    max1 = gb[row - 2][col + 1];
                else
                    max1 = 0;
                if(row - 1 > 0 && col + 2 <= n)
                    max2 = gb[row - 1][col + 2];
                else
                    max2 = 0;
                if( row + 1 <= n && col + 2 <= n)
                    max3 = gb[row + 1][col + 2];
                else
                    max3 = 0;
                if ( row + 2 <= n && col + 1 <= n)
                    max4 = gb[row + 2][col + 1];
                else
                    max4 = 0;

                gb[row][col] = Math.max(Math.max(max1, max2), Math.max(max3,max4)) + gb[row][col];
                //superMax = (superMax < gb[row][col]) ? gb[row][col] : superMax;
                if(done) break;
            }
            if(done) break;
        }
        System.out.println(gb[row][col]-2);

    }


    public static void main(String[] args) throws IOException {

        try
        {
            BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(aReader.readLine());
            String tokens = "";
            //gameboard

            for (int i = 0; i < t; i++)
            {
                int n = Integer.parseInt(aReader.readLine());
                int[][] gb = new int[n+1][n+1];
                buildGB(gb, n, aReader, tokens);
                updateGB(gb, n);


            }
        }catch (Exception e)
        {
            return;
        }
    }
}