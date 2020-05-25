package com.ctk0327.B17822;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M, T, x, d, k;
    static int result = 0;
    static int[][] changed;
    static boolean[][] hasToBeChanged;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        changed = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp = sc.nextInt();
                changed[i][j] = temp;
            }
        }
        while (T > 0) {
            x = sc.nextInt();
            d = sc.nextInt();
            k = sc.nextInt();
            rotate();
            hasToBeChanged = new boolean[N][M];
            boolean isChanged = false;
            int sum = 0;
            int count = 0;
            double average = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (isAdjacent(i, j)) {
                        hasToBeChanged[i][j] = true;
                        isChanged = true;
                    } else {
                        sum += changed[i][j];
                        if (!(changed[i][j] == 0)) {
                            count++;
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (hasToBeChanged[i][j]) {
                     changed[i][j]=0;
                    }
                }
            }

            average = (double)sum / count;

            if (!isChanged) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (changed[i][j] > average && changed[i][j]!=0) {
                            changed[i][j] -= 1;

                        } else if (changed[i][j] < average && changed[i][j]!=0) {
                            changed[i][j] += 1;
                        }
                    }
                }
            }
            T--;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result += changed[i][j];
            }
        }
        System.out.println(result);
    }

    private static void rotate() {
        for (int i = 0; i < N; i++) {
            if ((i+1) % x == 0) {
                int[] temp = Arrays.copyOf(changed[i], M);
                if (d == 0) {
                    for (int j = k; j < M; j++) {
                        changed[i][j] = temp[j - k];
                    }
                    for (int j = 0; j < k; j++) {
                        changed[i][j] = temp[M - k+j];
                    }
                } else if (d == 1) {
                    for (int j = 0; j < M - k; j++) {
                        changed[i][j] = temp[j + k];
                    }
                    for (int j = M - k; j < M; j++) {
                        changed[i][j] = temp[j + k - M];
                    }
                }
            }
        }
    }

    private static boolean isAdjacent(int i, int j) {
        int value = changed[i][j];
        if(value==0){
            return false;
        }
        boolean result = false;
        int left = 0, right = 0;
        if (j == 0) {
            left = M - 1;
            right = j + 1;
        } else if (j == M - 1) {
            left = j - 1;
            right = 0;
        } else {
            left = j - 1;
            right = j + 1;
        }
        if (i == 0) {
            if (changed[i][left] == value || changed[i][right] == value || changed[i + 1][j] == value) {
                result = true;
            }
        } else if (i == N - 1) {
            if (changed[i][left] == value || changed[i][right] == value || changed[i - 1][j] == value) {
                result = true;
            }
        } else {
            if (changed[i][left] == value || changed[i][right] == value || changed[i + 1][j] == value
                || changed[i - 1][j] == value) {
                result = true;
            }
        }
        return result;
    }
}
