package com.ctk0327.B10775;

import java.util.Scanner;

public class Main {
    static int G;
    static int P;
    static int parent[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        G=sc.nextInt();
        P=sc.nextInt();
        parent = new int[G + 1];
        for (int i = 0; i <=G; i++) {
            parent[i]=i;
        }
        int result=0;
        for (int i = 0; i < P; i++) {
            int temp=sc.nextInt();
            int temp2=find(temp);
            if(temp2==0){
                break;
            }else {
                merge(temp2,temp2-1);
                result++;
            }
        }
        System.out.println(result);
    }

    static int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

   static void merge(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) { return; }

        parent[u] = v;

    }
}
