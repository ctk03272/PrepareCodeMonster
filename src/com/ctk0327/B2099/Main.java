package com.ctk0327.B2099;

import java.util.Scanner;

public class Main {
    static int N, K, M;
    static int[][] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        N = sc.nextInt();
        K = sc.nextInt();
        M = sc.nextInt();
        input = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            input[i][sc.nextInt()] = 1;
            input[i][sc.nextInt()] = 1;
        }
        int[][] result = MatrixPow(K,input);
        for (int i = 0; i < M; i++) {
            sb.append(result[sc.nextInt()][sc.nextInt()]>0?"death":"life");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static int[][] MatrixPow(int K,int[][] inputMat) {
        if (K == 1) {
            return inputMat;
        }
        int[][] result = MatrixPow(K / 2,inputMat);
        result = MatrixMulti(result,result);
        if(K%2==1){
            result=MatrixMulti(result,inputMat);
        }
        return result;
    }

    static int[][] MatrixMulti(int[][] inputMat,int[][] inputMat2) {
        int[][] result = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    result[i][j] += inputMat[i][k] * inputMat2[k][j];
                }
                if (result[i][j] > 0) {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }
}
