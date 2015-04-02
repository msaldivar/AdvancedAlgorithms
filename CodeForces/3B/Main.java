//package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//@author Maurice Saldivar
public class Main
{
    public static class Boat
    {
        int type;
        int capacity;
        int position;

        public Boat(int type, int capacity, int position)
        {
            this.type = type;
            this.capacity = capacity;
            this.position = position;
        }
    }
    static Comparator<Boat> comparator = new Comparator<Boat>() {
        @Override
        public int compare(Boat o1, Boat o2) {
            return o2.capacity - o1.capacity;
        }
    };

    static Comparator<Boat> comparator2 = new Comparator<Boat>() {
        @Override
        public int compare(Boat o1, Boat o2) {
            return o1.type - o2.type;
        }
    };


    public static void main(String[] args) throws IOException {
        BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);
        int n = 0;
        int volume = 0;
        int type = 0;
        int carryCap = 0;
        int kayakLength = 0;
        int max = 0;
        String tokens[];
        tokens = aReader.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        volume = Integer.parseInt(tokens[1]);
        ArrayList<Boat> boatList = new ArrayList<Boat>();

        for(int i = 0; i < n; i++)
        {
            tokens = aReader.readLine().split(" ");
            type = Integer.parseInt(tokens[0]);
            carryCap = Integer.parseInt(tokens[1]);

            if (type == 1)
            {
                boatList.add(new Boat(type, carryCap, i));
                kayakLength++;
            }
            else
                boatList.add(new Boat(type, carryCap, i));
        }

        //I sort the array first by type than by capacity for both types
        ArrayList<Boat> SortedBoatList = new ArrayList<Boat>(boatList);
        Collections.sort(SortedBoatList, comparator2);
        Collections.sort(SortedBoatList.subList(0, kayakLength), comparator);
        Collections.sort(SortedBoatList.subList(kayakLength, n), comparator);
        ArrayList<Boat> finalList = new ArrayList<Boat>();

        int start = 0;
        int end = kayakLength;
        int finalLength = n;

        //to get true length
        while(volume > 0)
        {
            if(volume == 1)
            {
                if(start < kayakLength)
                {
                    max += SortedBoatList.get(start).capacity;
                    finalList.add(SortedBoatList.get(start));
                    start++;
                    volume--;
                }else
                    break;
            }else
            {
                if(start < kayakLength && end < finalLength)
                {
                    //add two kayaks together and see if the sum is greater than one catamarans. Since two kayaks equal one catamarans. I only want to add a
                    //catamarans if its capacity is greater than the two kayaks.
                    if (start + 1 < kayakLength)
                        if (SortedBoatList.get(start).capacity + SortedBoatList.get(start + 1).capacity > SortedBoatList.get(end).capacity) {
                            max += SortedBoatList.get(start).capacity;
                            finalList.add(SortedBoatList.get(start));
                            start++;
                            volume--;
                        } else if (SortedBoatList.get(start).capacity > SortedBoatList.get(end).capacity) {
                            max += SortedBoatList.get(start).capacity;
                            finalList.add(SortedBoatList.get(start));
                            start++;
                            volume--;
                        } else {
                            max += SortedBoatList.get(end).capacity;
                            finalList.add(SortedBoatList.get(end));
                            end++;
                            volume -= 2;
                        }
                    else
                    {
                        max += SortedBoatList.get(end).capacity;
                        finalList.add(SortedBoatList.get(end));
                        end++;
                        volume -= 2;
                    }
                }else if(start < kayakLength) //only kayaks
                {
                    max += SortedBoatList.get(start).capacity;
                    finalList.add(SortedBoatList.get(start));
                    start++;
                    volume--;
                }else if ( end < finalLength ) //only catamarans
                {
                    max += SortedBoatList.get(end).capacity;
                    finalList.add(SortedBoatList.get(end));
                    end++;
                    volume -= 2;
                }else
                    break;
            }
        }


        aWriter.println(max);
        for (Boat val : finalList)
            aWriter.println(val.position + 1);


    }
}
