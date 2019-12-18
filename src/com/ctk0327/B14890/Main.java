package com.ctk0327.B14890;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, L;
    static int[][] input;
    static int result;

    public static void main(String[] args) {

        Solve.run();
    }

    static class Solve {
        static void getInput() {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            L = sc.nextInt();
            input = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    input[i][j] = sc.nextInt();
                }
            }
        }

        static void run() {
            getInput();
            solve();
            print();
        }

        private static void solve() {
            int[] testLine;
            for (int i = 0; i < N; i++) {
                testLine = getLine(true, i);
                checkMax(testLine);
            }
            for (int i = 0; i < N; i++) {
                testLine = getLine(false, i);
                checkMax(testLine);
            }
        }

        private static void checkMax(int[] testLine) {
            int start = 0;
            boolean[] isUsed=new boolean[N];
            boolean isMakeLine = true;
            for (int i = 1; i < N; i++) {
                if (testLine[start] != testLine[i]) {
                    if ((testLine[start] - testLine[i] == 1 || testLine[start] - testLine[i] == -1)) {
                        if (testLine[start] - testLine[i] == -1) {
                            for (int j = 1; j <= L; j++) {
                                if (i - j < 0 || i - j >= N || testLine[i - 1] != testLine[i - j] || isUsed[i-j]) {
                                    isMakeLine = false;
                                    break;
                                }
                                isUsed[i - j]=true;
                            }
                            start = i;
                        }
                        if (testLine[start] - testLine[i] == 1) {
                            for (int j = 0; j < L; j++) {
                                if (i + j < 0 || i + j >= N || testLine[i] != testLine[i + j] || isUsed[i+j]) {
                                    isMakeLine = false;
                                    break;
                                }
                                isUsed[i + j]=true;
                            }
                            start = i;
                        }

                    } else {
                        isMakeLine = false;
                        break;
                    }
                }
            }
            if (isMakeLine) {
                result++;
            }
/*            StringBuilder sb=new StringBuilder();
            Arrays.stream(testLine).forEach(sb::append);
            sb.append(isMakeLine);
            System.out.println(sb.toString());*/
        }

        static int[] getLine(boolean isGaro, int index) {
            int[] result = new int[N];
            if (isGaro) {
                result = input[index];
            } else {
                for (int i = 0; i < N; i++) {
                    result[i] = input[i][index];
                }
            }
            return result;
        }

        static void print() {
            System.out.println(result);
        }
    }
}
