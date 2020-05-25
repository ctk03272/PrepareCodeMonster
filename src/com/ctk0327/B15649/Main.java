package com.ctk0327.B15649;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] col;
    static ArrayList<String> ar;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ar = new ArrayList<>();
        N = sc.nextInt();
        M = sc.nextInt();

        // 1부터 N까지 시작노드로 삼음
        for (int i = 1; i <= N; i++) {
            col = new int[M + 1];
            col[1] = i;

            dfs(2);
        }
    }

    static void dfs(int row) {
        if (row > M) {
            printAnswer();
            return;
        } else {
            for (int i = 1; i <= N; i++) {
                col[row] = i;
                if (isPossible(row)) {
                    dfs(row + 1);
                } else {
                    col[row] = 0;
                }
            }
        }

    }

    private static boolean isPossible(int row) {

        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) {
                return false;
            }
        }
        return true;
    }

    private static void printAnswer() {
        for (int i = 1; i <= M; i++) {
            System.out.print(col[i] + " ");
        }
        System.out.println();
    }
}
