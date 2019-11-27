package com.ctk0327.B14889;

import java.util.Scanner;

public class Main {
    static int N;
    static int score[][];
    static int score1 = 0;
    static int score2 = 0;
    static int min = Integer.MAX_VALUE;
    static boolean team[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        score = new int[N + 1][N + 1];
        team = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                score[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= N; i++) {
            team[i] = true;
            dfs(2);
        }
    }

    private static void dfs(int number) {
        if (number > N / 2) {
            getScore();
        } else {
            for (int i = 1; i <= N; i++) {
                team[i] = true;
                if (isPossible(number)) {
                    dfs(number + 1);
                } else {
                    team[i] = false;
                }
            }
            team[N] = false;
        }
    }

    private static boolean isPossible(int row) {
        return true;
    }

    private static void getScore() {
        System.out.println("?");
        int[] team1 = new int[N / 2];
        int[] team2 = new int[N / 2];

    }
}
