package com.ctk0327.SecondSajun;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int V,E;
    static int result=0;
    static boolean check;
    static int[] parent;
    static ArrayList<Line> ar;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        V=sc.nextInt();
        E=sc.nextInt();
        parent=new int[V+1];
        ar=new ArrayList<>();
        for (int i = 1; i <=V ; i++) {
            parent[i]=i;
        }

        for (int i = 0; i <E ; i++) {
            ar.add(new Line(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }

        Collections.sort(ar);

        for (int i = 0; i <E ; i++) {
            mergeLine(ar.get(i));
            if(check){
                result+=ar.get(i).val;
            }
        }

        System.out.println(result);
    }

    private static void mergeLine(Line line) {
        check=false;
        int u=find(line.from);
        int v=find(line.to);

        if(u==v){
            return;
        }
        parent[u]=v;
        check=true;
    }

    private static int find(int from) {
        if(from==parent[from]){
            return from;
        }
        return parent[from]=find(parent[from]);
    }
}
class Line implements Comparable<Line>{
    int from;
    int to;
    int val;

    public Line(int from, int to, int val) {
        this.from = from;
        this.to = to;
        this.val = val;
    }

    @Override
    public int compareTo(Line o) {
        return this.val-o.val;
    }
}