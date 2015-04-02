//package com.company;
import java.io.*;


//@author Maurice Saldivar
public class Main
{
    public static int xCount = 0;
    public static int oCount = 0;
    public static int xWins = 0;
    public static int oWins = 0;
    public static char[][] GB = new char[3][3]; //gameBoard


    private static void checkRows()
    {
        char temp = GB[0][0];
        int counter = 0;
        //rows
        for (int i = 0; i < 3; i++)
        {
            temp = GB[i][0];
            for (int j = 0; j < 3; j++)
            {
                if(temp == GB[i][j] && (temp == 'X' || temp == '0'))
                    counter++;
                if(counter == 3)
                {
                    if (temp == 'X')
                    {
                        xWins++;
                    } else
                    {
                        oWins++;
                    }
                }
            }
            counter = 0;
        }
    }

    private static void checkCols()
    {
        char temp = GB[0][0];
        int counter = 0;
        //cols
        for (int i = 0; i < 3; i++)
        {
            temp = GB[0][i];
            for (int j = 0; j < 3; j++)
            {
                if(temp == GB[j][i] && (temp == 'X' || temp == '0'))
                    counter++;
                if(counter == 3)
                {
                    if(temp == 'X')
                    {
                        xWins++;
                    }
                    else
                    {
                        oWins++;
                    }

                }
            }
            counter = 0;
        }
    }

    private static void checkDiag()
    {
        char temp = GB[0][0];
        int xCounter = 0;
        int yCounter = 0;
        //diag
        for (int i = 0; i < 3;  i++)
        {
            temp = GB[i][i];
            if(temp == 'X') {
                xCounter++;
            }else if(temp == '0')
            {
                yCounter++;
            }
            if(xCounter == 3 || yCounter == 3)
            {
                if(temp == 'X')
                {
                    xWins++;
                }
                else
                {
                    oWins++;
                }

            }

        }


        xCounter = 0;
        yCounter = 0;
        //anti-diag
        for (int i = 0; i < 3; i++)
        {
            temp = GB[i][2-i];
            if(temp == 'X') {
                xCounter++;
            }else if(temp == '0')
            {
                yCounter++;
            }
            if(xCounter == 3 || yCounter == 3)
            {
                if(temp == 'X')
                {
                    xWins++;
                }
                else
                {
                    oWins++;
                }

            }

        }

    }


    public static void main(String[] args) throws IOException{
        BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);
        String tokens;
        String output = "";
        tokens = aReader.readLine();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                GB[i][j] = tokens.charAt(j);
                if(GB[i][j] == 'X')
                    xCount++;
                if(GB[i][j] == '0')
                    oCount++;
            }
            tokens = aReader.readLine();
        }

        checkRows();
        checkCols();
        checkDiag();

        if(oWins > 0 && xWins > 0) output = "illegal";
        else if(xCount - oCount >= 2 || oCount > xCount) output = "illegal";
        else if(xWins>0 && xCount <= oCount) output = "illegal";
        else if(oWins > 0 && oCount != xCount) output = "illegal";
        else if(xWins > 0) output="the first player won";
        else if(oWins > 0) output="the second player won";
        else if(oCount + xCount == 9) output="draw";
        else if(oCount == xCount) output="first";
        else if(xCount > oCount) output="second";

        System.out.println(output);
    }
}
