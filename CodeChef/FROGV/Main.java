import java.io.*;
import java.util.*;

//@author Maurice Saldivar
public class Main
{

    // a class to help keep track of the frogs position and
    //speaking distance
    public static class Frog
    {
        int xCord;
        int origPos;
        int sDistance; //speaking distance

        Frog(int x){ xCord = x; }

    }
    //allows me to sort by xCord;
    public static Comparator<Frog> compareFrog = new Comparator<Frog>()
    {
        public int compare(Frog frog1, Frog frog2)
        {
            return frog1.xCord - frog2.xCord;
        }
    };



    public static void main(String[] args) throws IOException {
        BufferedReader aReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter aWriter = new PrintWriter(System.out, true);

        String[] tokens = aReader.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);
        int P = Integer.parseInt(tokens[2]);

        tokens = aReader.readLine().split(" ");
        Frog[] frogsPhone = new Frog[N];

        for(int i = 0; i < N; i++)
            frogsPhone[i] = new Frog(Integer.parseInt(tokens[i]));


        Frog[] frogsSorted = Arrays.copyOf(frogsPhone, N);
        Arrays.sort(frogsSorted, compareFrog);

        int sDistance = 0;
        for (int i = 1; i < N; i++)
        {
            if(frogsSorted[i].xCord - frogsSorted[i-1].xCord > K)
                sDistance++;

            frogsSorted[i].sDistance = sDistance;

        }

        for(int i = 0; i < P; i++)
        {
            tokens = aReader.readLine().split(" ");
            int frog1 = Integer.parseInt(tokens[0]);
            int frog2 = Integer.parseInt(tokens[1]);

            if(frogsPhone[frog1 - 1].sDistance == frogsPhone[frog2 - 1].sDistance)
                aWriter.println("Yes");
            else
                aWriter.println("No");


        }


    }
}
