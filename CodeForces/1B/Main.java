//package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@Author Maurice Saldivar


public class Main
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(aReader.readLine());
        String RXCY = "R[1-9][0-9]*C[1-9][0-9]*";
        String finalAnswer = "";
        String row = "";
        String col = "";
        boolean found = false;
        String temp = aReader.readLine();
        for (int i = 0; i < n; i++)
        {
            if(temp.matches(RXCY))
            {
                row = temp.substring(1, temp.indexOf("C"));
                col = temp.substring(temp.indexOf("C")+1);
                int tempCol = Integer.parseInt(col);
                while(tempCol-- > 0)
                {
                    // mod by 26 becuase of 26 letters in the alphabet
                    //65 is A in ascii code
                    int val = tempCol % 26;
                    finalAnswer = new String(new char[] {(char)(val+65)}) + finalAnswer;
                    tempCol /= 26;

                }
                System.out.println(finalAnswer + row);
                finalAnswer= "";

            }else
            {
                int index = 0;
                int tempCol = 0;
                while(Character.isLetter(temp.charAt(index)))
                {
                    //26 represents how many letters in the alphabet and 64 is A ascii code
                    tempCol = 26 * tempCol + temp.charAt(index)-64;
                    index++;
                }
                row = temp.substring(index);
                System.out.println("R" + row + "C" + tempCol);
                finalAnswer = "";
            }
            temp = aReader.readLine();
        }

    }
}
