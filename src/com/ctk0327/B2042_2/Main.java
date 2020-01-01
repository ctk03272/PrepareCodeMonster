package com.ctk0327.B2042_2;

import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[] input;
    static long[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        input = new int[N+1];
        tree=new long[N+1];
        for (int i = 1; i <= N; i++) {
            input[i] = sc.nextInt();
            updateInput(i,input[i]);
        }
        for (int i = 0; i < K + M; i++) {
            int decide = sc.nextInt();
            int first=sc.nextInt();
            int second=sc.nextInt();
            if (decide == 1) {
                updateInput(first, second-input[first]);
                input[first]=second;
            } else if (decide == 2) {
                sumInput(first, second);
            }
        }
    }

    private static void sumInput(int nextInt, int nextInt1) {
        System.out.println(sumInput(nextInt1) - sumInput(nextInt-1));
    }

    private static long sumInput(int i) {
        long ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= (i & -i);
        }
        return ans;
    }

    private static void updateInput(int nextInt, long nextInt1) {
            while(nextInt<=N){
                tree[nextInt]+=nextInt1;
                nextInt+=(nextInt & -nextInt);
            }
    }
}
