//package com.company;
import java.io.*;
//@author Maurice Saldivar
//did research to find equations online
//it's like solving a system of equations


public class Main {

    public static void main(String[] args) throws Exception {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(System.out, true);
            String tokens[];
            //coordinate variables
            double x1, y1, r1, x2, y2, r2, x3, y3, r3;

            tokens = br.readLine().split("\\s+");
            x1 = Integer.parseInt(tokens[0]);
            y1 = Integer.parseInt(tokens[1]);
            r1 = Integer.parseInt(tokens[2]);
            tokens = br.readLine().split("\\s+");
            x2 = Integer.parseInt(tokens[0]);
            y2 = Integer.parseInt(tokens[1]);
            r2 = Integer.parseInt(tokens[2]);
            tokens = br.readLine().split("\\s+");
            x3 = Integer.parseInt(tokens[0]);
            y3 = Integer.parseInt(tokens[1]);
            r3 = Integer.parseInt(tokens[2]);

            double a1, b1, c1, d1, a2, b2, c2, d2, d;
            a1 = 2 * (x2 - x1);
            a2 = 2 * (x3 - x2);
            b1 = 2 * (y2 - y1);
            b2 = 2 * (y3 - y2);
            c1 = r1 * r1 - r2 * r2;
            c2 = r2 * r2 - r3 * r3;
            d1 = x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1;
            d2= x3 * x3 - x2 * x2 + y3 * y3 - y2 * y2;
            d = a1 * b2 - a2 * b1;

            if (Math.abs(d) < 0.000000001) {
                return;
            }

            double k1, k2, l1, l2, a, b, c, q2, x, y;
            k1 = (c1 * b2 - c2 * b1) / d;
            k2=(d1 * b2 - d2 * b1) / d;
            l1=(a1 * c2 - a2 * c1) / d;
            l2=(a1 * d2 - a2 * d1) / d;
            a=(k1 * k1 + l1 * l1);
            b=(2 * k1 * (k2 - x1) + 2 * l1 * ( l2 - y1) - r1 * r1);
            c=(k2 - x1) * (k2 - x1) + (l2 - y1) * (l2 - y1);

            if (Math.abs(a)>0.000001){
                d = b * b - 4 * a * c;
                if (d < 0) {
                    return;
                }
                q2 = (-b - Math.sqrt(d)) / (2 * a);
                if (q2 < 0){
                    q2 = (-b + Math.sqrt(d)) / (2 * a);
                    if (q2 < 0)
                        return;
                }
            } else{
                if (Math.abs(b) < 0.000001) {
                    return;
                }
                else q2 = c / b;
            }

            x = k1 * q2 + k2;
            y= l1 * q2 + l2;
            pw.printf("%.5f %.5f\n", x, y);


        } catch (Exception e) {
            return;
        }

    }
}
