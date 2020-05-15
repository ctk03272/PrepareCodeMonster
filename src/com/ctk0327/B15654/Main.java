package com.ctk0327.B15654;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N, M;
    static int[] input;
    static int[] output;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new int[N];
        output = new int[M];
        visited = new boolean[8];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
        getAnswer(0);
    }

    private static void getAnswer(int i) {
        if (i == M) {
            for (int j = 0; j < M; j++) {
                System.out.print(output[j] + " ");
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < N; j++) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            output[i] = input[j];
            getAnswer(i + 1);
            visited[j] = false;
        }
    }
}
