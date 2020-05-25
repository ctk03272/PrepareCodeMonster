package com.ctk0327.B2157;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int start, end, score;
    static int[][] scores;
    static int[][] totalScore;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        scores = new int[N + 1][N + 1];
        totalScore = new int[M + 1][N + 1];
        for (int i = 0; i < K; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            score = sc.nextInt();
            if (scores[start][end] < score && start<end) {
                scores[start][end] = score;
            }
        }
        for (int i = 0; i <= M; i++) {
            Arrays.fill(totalScore[i], -1);
        }
        for (int i = 1; i <= N; i++) {
            if (scores[1][i] != 0) {
                totalScore[1][1] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 2; k <= M; k++) {
                    if (scores[i][j] != 0) {
                        if (totalScore[k - 1][i] != -1
                            && totalScore[k][j] < totalScore[k - 1][i] + scores[i][j]) {
                            totalScore[k][j] = totalScore[k - 1][i] + scores[i][j];
                        }
                    }
                }
            }
        }
        for (int i = 2; i <= M; i++) {
            if (totalScore[i][N] > result) {
                result = totalScore[i][N];
            }
        }
        System.out.println(result);
    }
}
