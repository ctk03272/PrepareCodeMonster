package com.ctk0327.B6569;

import java.util.Scanner;

public class Main {
    static double[][] dp;
    static double[][] bricks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp = new double[12][12];
        bricks = new double[12][12];
        makeDp();
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0) {
                break;
            }
            System.out.println(dp[x][y]);
        }
    }

    private static void makeDp() {
        //벽돌을 쌓아가면서 쌓을 수 있는 모든 상태를 저장해 나가야한다
        //어떤 식으로 벽돌을 쌓을지가 문제
        //dp와 어떤식으로 벽돌을 쌓는상태를 저장할지가 문제....;;
        //각 줄별로 벽돌을 쌓을 때 빈칸을 있는 상태로 쌓는건 안된다.
        for (int i = 1; i <= 11; i++) {
            for (int j = 1; j <= 11; j++) {
                if (j >= 2) {
                    bricks[i][j] = bricks[i][j - 2] + 1;
                }
            }
        }
    }
}
