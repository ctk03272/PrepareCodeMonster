package com.ctk0327.B2156;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N + 1];
        int[] max = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            input[i] = sc.nextInt();
        }
        max[1] = input[1];
        if (N >= 2) {
            max[2] = input[2] + input[1];
        }
        for (int i = 3; i <= N; i++) {
            max[i] = max[i - 1];
            if (max[i] < max[i - 2] + input[i]) {
                max[i] = max[i - 2] + input[i];
            }
            if (max[i] < max[i - 3] + input[i - 1] + input[i]) {
                max[i] = max[i - 3] + input[i - 1] + input[i];
            }
        }
        System.out.println(max[N]);
    }
}