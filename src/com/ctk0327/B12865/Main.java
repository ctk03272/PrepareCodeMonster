package com.ctk0327.B12865;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, K;
    static Stuff StuffList[];
    static long w[][];
    static long result = Long.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        StuffList = new Stuff[N+1];
        w = new long[K + 1][N+1];

        for (int i = 1; i <= N; i++) {
            StuffList[i] = new Stuff(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 0 || j == 0) {
                    w[i][j] = 0;
                } else {
                    if (i < StuffList[j].weight) {
                        w[i][j] = w[i][j - 1];
                    } else {
                        w[i][j] = Math.max(w[i][j - 1], w[i - StuffList[j].weight][j-1] + StuffList[j].value);
                    }
                }
            }
        }
        for (int i = 0; i <=K ; i++) {
            for (int j = 0; j <=N ; j++) {
              if(w[i][j]>result){
                  result=w[i][j];
              }
            }
        }
        System.out.println(result);
    }
}

class Stuff implements Comparable<Stuff> {
    int weight;
    int value;
    boolean uesd = false;

    public Stuff(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public int compareTo(Stuff o) {
        return this.weight - o.weight;
    }
}