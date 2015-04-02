//package com.company;
import java.io.*;
import java.util.ArrayList;

//@author Maurice Saldivar
public class Main
{

    public static void main(String[] args) throws IOException {
	    BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);
        String[] tokens;
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        tokens = aReader.readLine().split(" ");
        start.append(tokens[0]);
        tokens = aReader.readLine().split(" ");
        end.append(tokens[0]);
        ArrayList<String> path = new ArrayList<String>();
        int counter = 0;


        while(true)
        {
            if(start.charAt(0) > end.charAt(0) && start.charAt(1) > end.charAt(1))
            {
                char tempLetter = start.charAt(0);
                tempLetter -= 1;
                char tempNum = start.charAt(1);
                tempNum -= 1;
                start.setCharAt(0, tempLetter);
                start.setCharAt(1, tempNum);
                path.add("LD");
                counter++;


            }else if (start.charAt(0) == end.charAt(0) && start.charAt(1) != end.charAt(1))
            {
                if(start.charAt(1) > end.charAt(1) && start.charAt(1) != end.charAt(1))
                {
                    char tempNum = start.charAt(1);
                    tempNum -= 1;
                    start.setCharAt(1, tempNum);
                    path.add("D");

                }else if(start.charAt(1) < end.charAt(1) && start.charAt(1) != end.charAt(1))
                {
                    char tempNum = start.charAt(1);
                    tempNum += 1;
                    start.setCharAt(1, tempNum);
                    path.add("U");
                }
                counter++;
            }else if(start.charAt(0) < end.charAt(0) && start.charAt(1) > end.charAt(1))
            {
                char tempLetter = start.charAt(0);
                tempLetter += 1;
                char tempNum = start.charAt(1);
                tempNum -= 1;
                start.setCharAt(0, tempLetter);
                start.setCharAt(1, tempNum);
                path.add("RD");
                counter++;
            }else if(start.charAt(1) == end.charAt(1) && start.charAt(0) > end.charAt(0))
            {
                char tempLetter = start.charAt(0);
                tempLetter -= 1;
                start.setCharAt(0, tempLetter);
                path.add("L");
                counter++;
            }else if (start.charAt(1) == end.charAt(1) && start.charAt(0) < end.charAt(0))
            {
                char tempLetter = start.charAt(0);
                tempLetter += 1;
                start.setCharAt(0, tempLetter);
                path.add("R");
                counter++;
            }else if(start.charAt(0) > end.charAt(0) && start.charAt(1) < end.charAt(1))
            {
                char tempLetter = start.charAt(0);
                tempLetter -= 1;
                char tempNum = start.charAt(1);
                tempNum += 1;
                start.setCharAt(0, tempLetter);
                start.setCharAt(1, tempNum);
                path.add("LU");
                counter++;
            }else if (start.charAt(0) < end.charAt(0) && start.charAt(1) < end.charAt(1))
            {
                char tempLetter = start.charAt(0);
                tempLetter += 1;
                char tempNum = start.charAt(1);
                tempNum += 1;
                start.setCharAt(0, tempLetter);
                start.setCharAt(1, tempNum);
                path.add("RU");
                counter++;
            }

            else if(start.charAt(0) == end.charAt(0) && start.charAt(1) == end.charAt(1))
            {
                break;
            }



        }

        aWriter.println(counter);
        for(String val : path)
            aWriter.println(val);

    }
}
