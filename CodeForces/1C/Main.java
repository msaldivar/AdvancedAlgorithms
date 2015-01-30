//package com.company;
import java.io.*;


//@author Maurice Saldivar

public class Main
{
    private static double gcd(double x, double y)
    {
        if(x < 0.0001){
            return y;
        }
        if(y < 0.0001){
            return x;
        }
        return gcd(y, x % y);
    }

    public static void main(String[] args) throws IOException {
	    BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);
        String[] tokens = aReader.readLine().split(" ");

        //coordinate system
        double X1, Y1, X2, Y2, X3, Y3;
        X1 = Double.parseDouble(tokens[0]);
        Y1 = Double.parseDouble(tokens[1]);
        tokens = aReader.readLine().split(" ");
        X2 = Double.parseDouble(tokens[0]);
        Y2 = Double.parseDouble(tokens[1]);
        tokens = aReader.readLine().split(" ");
        X3 = Double.parseDouble(tokens[0]);
        Y3 = Double.parseDouble(tokens[1]);

        //distance formula
        double lengthA = Math.sqrt(((X1 - X2) * (X1 - X2)) + ((Y1 - Y2) * (Y1 - Y2)));
        double lengthB = Math.sqrt(((X1 - X3) * (X1 - X3)) + ((Y1 - Y3) * (Y1 - Y3)));
        double lengthC = Math.sqrt(((X3 - X2) * (X3 - X2)) + ((Y3 - Y2) * (Y3 - Y2)));

        //angles using law of cos
        double angleA = Math.acos((lengthB*lengthB+lengthC*lengthC-lengthA*lengthA)/(2*lengthB*lengthC));
        double angleB = Math.acos((lengthA*lengthA+lengthC*lengthC-lengthB*lengthB)/(2*lengthA*lengthC));
        double angleC = Math.acos((lengthB*lengthB+lengthA*lengthA-lengthC*lengthC)/(2*lengthB*lengthA));

        //herons formula found on wiki
        double perimeter = (lengthA + lengthB + lengthC) / 2;
        double radius = lengthA * lengthB * lengthC / (4 * Math.sqrt(perimeter * (perimeter - lengthA) * (perimeter - lengthB) * (perimeter - lengthC)));
        double denominator = gcd(gcd(angleA, angleB), angleC);
        double numSides = Math.PI/denominator;

        double area = numSides / 2 * radius * radius * Math.sin(2 * Math.PI / numSides);
        aWriter.println(area);



    }
}
