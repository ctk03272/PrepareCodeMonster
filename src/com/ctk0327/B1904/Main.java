package com.ctk0327.B1904;

import java.util.Scanner;

public class Main {
    static int N;
    static long result[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        result=new long[2][N+1];
        result[0][1]=0;
        result[1][1]=1;
        result[0][2]=1;
        result[1][2]=1;
        for (int i = 3; i <=N; i++) {
            result[0][i]=(result[0][i-2]+result[1][i-2])%15746;
            result[1][i]=(result[0][i-2]+result[1][i-2]+result[0][i-1])%15746;
        }
        System.out.println((result[0][N]+result[1][N])%15746);
    }
}
