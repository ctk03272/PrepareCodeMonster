package com.ctk0327.B14501;

import java.util.Scanner;

public class Main {
    static int[] T;
    static int[] P;
    static int[] max;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N + 1];
        P = new int[N + 1];
        max = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
            max[i] = P[i];
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i - j >= T[j]) {
                    max[i] = Math.max(P[i] + max[j], max[i]);
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if(i+T[i]<=N+1){
                if(answer<max[i]){
                    answer=max[i];
                }
            }
        }
        System.out.println(answer);
    }
}
