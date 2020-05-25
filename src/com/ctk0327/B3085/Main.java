package com.ctk0327.B3085;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static char[][] input;
    static int N;
    static int result = 0;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, 0 - 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        input = new char[N][N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextLine().toCharArray();
        }
        //전체를 순회하면서 전후좌우로 색을 바꿔가면서 탐색한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    char temp = input[i][j];
                    if (0 <= i + dx[k] && i + dx[k] < N && 0 <= j + dy[k] && j + dy[k] < N) {
                        input[i][j] = input[i + dx[k]][j + dy[k]];
                        input[i + dx[k]][j + dy[k]]=temp;
                        solve();
                        temp=input[i + dx[k]][j + dy[k]];
                        input[i + dx[k]][j + dy[k]]=input[i][j];
                        input[i][j]=temp;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            int count = 1;
            int count2 = 1;
            for (int j = 1; j < N; j++) {
                // 가로 방향과 세로방향의 한번에 구함
                if (input[i][j] == input[i][j - 1]) {
                    ++count;
                } else {
                    result = Math.max(result, count);
                    count = 1;
                }
                if (input[j][i] == input[j - 1][i]) {
                    ++count2;
                } else {
                    result = Math.max(result, count2);
                    count2 = 1;
                }
            }
            result = Math.max(result, count);
            result = Math.max(result, count2);
        }
    }
}
