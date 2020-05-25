package com.ctk0327.B2096;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] input;
    static int[][] maxDp;
    static int[][] minDp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input=new int[N][3];
        maxDp = new int[N][3];
        minDp = new int[N][3];

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < 3; j++) {
                input[i][j]=sc.nextInt();
            }
        }

        for (int i = 0; i <3 ; i++) {
            maxDp[0][i]=input[0][i];
            minDp[0][i]=input[0][i];
        }

        for (int i = 1; i <N ; i++) {
            maxDp[i][0]=Math.max(maxDp[i-1][0],maxDp[i-1][1])+input[i][0];
            maxDp[i][1]=Math.max(Math.max(maxDp[i-1][0],maxDp[i-1][1]),maxDp[i-1][2])+input[i][1];
            maxDp[i][2]=Math.max(maxDp[i-1][2],maxDp[i-1][1])+input[i][2];

            minDp[i][0]=Math.min(minDp[i-1][0],minDp[i-1][1])+input[i][0];
            minDp[i][1]=Math.min(Math.min(minDp[i-1][0],minDp[i-1][1]),minDp[i-1][2])+input[i][1];
            minDp[i][2]=Math.min(minDp[i-1][2],minDp[i-1][1])+input[i][2];
        }
        System.out.print(Math.max(Math.max(maxDp[N-1][0],maxDp[N-1][1]),maxDp[N-1][2]));
        System.out.print(" ");
        System.out.print(Math.min(Math.min(minDp[N-1][0],minDp[N-1][1]),minDp[N-1][2]));
    }
}
