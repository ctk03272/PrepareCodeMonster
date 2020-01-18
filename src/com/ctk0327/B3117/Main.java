package com.ctk0327.B3117;

        import java.util.Scanner;

public class Main {
    static int N,K,M;
    static int[] first;
    static int[] rec;
    static int[][] result;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        M=sc.nextInt();
        first=new int[N];
        for (int i = 0; i < N; i++) {
            first[i]=sc.nextInt();
        }
        rec=new int[K+1];
        for (int i = 1; i <=K; i++) {
            rec[i]=sc.nextInt();
        }
        result=new int[M+1][K+1];

        for (int i = 1; i <=M; i++) {
            for (int j = 1; j <=K ; j++) {
            }
        }
        for (int i = 1; i <=K ; i++) {
            System.out.println(result[M][i]);
        }
    }
}
