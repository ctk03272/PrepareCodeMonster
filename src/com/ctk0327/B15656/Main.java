package com.ctk0327.B15656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] input;
    static int[] output;
    static boolean[] visited;
    static StringBuffer sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new int[N];
        output = new int[M];
        visited = new boolean[8];
        sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
        getAnswer(0);
        System.out.println(sb.toString());
    }

    private static void getAnswer(int i) {
        if (i == M) {
            for (int j = 0; j < M; j++) {
                sb.append(output[j] + " ");
            }
            sb.append('\n');
            return;
        }
        for (int j = 0; j < N; j++) {
            if ((i != 0 && output[i - 1] > input[j])) {
                continue;
            }
            visited[j] = true;
            output[i] = input[j];
            getAnswer(i + 1);
            visited[j] = false;
        }
    }
}
