package com.ctk0327.B2878;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static long M;
    static int N;
    static long answer;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        input = new int[N];
        long sum = -M;
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
            sum+=input[i];
        }
        Arrays.sort(input);
        for (int i = 0; i < N; i++) {
            long temp = Math.min(input[i], sum / (N - i));
            answer += temp * temp;
            sum -= temp;
        }

        System.out.println(answer);
    }
}
