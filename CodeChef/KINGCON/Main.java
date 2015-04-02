//package com.company;
import java.io.*;
import java.util.*;
//@author Maurice Saldivar


public class Main {

    static class node{
        List<node> edges= new ArrayList<node>();
        boolean visited;
        boolean critical;
        int Low;
        int Depth;

        void DFS(){

            visited=true;
            Depth = 0;
            Low = 0;
            int z = 0;

            for(node n:edges){
                if(!n.visited){
                    z++;
                    n.DFS(this);
                }
            }
            if(z>1) {
                critical = true;
            }
        }

        void DFS(node p){
            visited = true;
            Depth = p.Depth+1;
            Low = Depth;
            for(node n:edges){
                if(!n.visited){
                    n.DFS(this);
                    Low = Math.min(Low,n.Low);
                    if(n.Low >= Depth) {
                        critical = true;
                    }
                }else if(n != p){
                    Low = Math.min(Low,n.Depth);
                }
            }
        }
    }






    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int T=Integer.parseInt(br.readLine().trim());

        for(int test=0;test<T;++test){
            String[] line = br.readLine().split(" ");
            int N=Integer.parseInt(line[0]);
            int M=Integer.parseInt(line[1]);
            int K=Integer.parseInt(line[2]);
            node[] graph= new node[N];

            for (int n=0; n<N; ++n)
                graph[n]=new node();

            for (int m=0; m<M; ++m){
                line = br.readLine().split(" ");
                int c1=Integer.parseInt(line[0]);
                int c2=Integer.parseInt(line[1]);
                graph[c1].edges.add(graph[c2]);
                graph[c2].edges.add(graph[c1]);
            }

            graph[0].DFS();

            int Protect=0;
            for (int n=0; n<N; ++n)
                if(graph[n].critical)++Protect;

            pr.println(Protect*K);
            pr.flush();
        }





    }
}
