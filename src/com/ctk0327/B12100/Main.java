package com.ctk0327.B12100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    static int N;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] input = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        doRun(1, input);
        System.out.println(result);
    }

    static void doRun(int i, int[][] input) {
        if (i > 5) {
            return;
        }
/*        up(makeInput(input));
        down(makeInput(input));
        left(makeInput(input));
        right(makeInput(input));*/

        doRun(i+1, up(makeInput(input)));
        doRun(i+1, down(makeInput(input)));
        doRun(i+1, left(makeInput(input)));
        doRun(i+1, right(makeInput(input)));
    }

    private static int[][] makeInput(int[][] input) {
        int[][] re = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                re[i][j] = input[i][j];
            }
        }
        return re;
    }

    static int[][] up(int[][] input) {
        for (int i = 0; i < N; i++) {
            int[] newInput = new int[N];
            for (int j = 0; j < N; j++) {
                newInput[j] = input[j][i];
            }
            int[] resultInput = makeMove(newInput, false);
            for (int j = 0; j < N; j++) {
                input[j][i] = resultInput[j];
            }
        }
        checkMax(input);
        return input;
    }

    private static void checkMax(int[][] input) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] > result) {
                    result = input[i][j];
                }
            }
        }
    }

    static int[][] left(int[][] input) {
        for (int i = 0; i < N; i++) {
            input[i] = makeMove(input[i], false);
        }
        checkMax(input);
        return input;
    }

    static int[][] right(int[][] input) {
        for (int i = 0; i < N; i++) {
            int[] newInput = new int[N];
            for (int j = 0; j < N; j++) {
                newInput[j] = input[i][N - 1 - j];
            }
            input[i] = makeMove(newInput, true);
        }
        checkMax(input);
        return input;
    }

    static int[][] down(int[][] input) {
        for (int i = 0; i < N; i++) {
            int[] newInput = new int[N];
            for (int j = 0; j < N; j++) {
                newInput[j] = input[N - 1 - j][i];
            }
            int[] resultInput = makeMove(newInput, true);
            for (int j = 0; j < N; j++) {
                input[N - 1 - j][i] = resultInput[N - 1 - j];
            }
        }
        checkMax(input);
        return input;
    }

    static int[] makeMove(int[] input, boolean isReverse) {
        boolean needSum = false;
        Deque<Integer> ar = new LinkedList<>();
        int inputLength = input.length;
        for (int i = 0; i < inputLength; i++) {
            if (input[i] != 0) {
                ar.add(input[i]);
            }
        }
        needSum = false;
        int arLength = ar.size();
        for (int i = 0; i < arLength - 1; i++) {
            int first = ar.removeFirst();
            int second = ar.removeFirst();
            if (first == second) {
                ar.offerLast(first + second);
                if (i == arLength - 2) {
                    needSum = true;
                }
                i++;
            } else {
                ar.offerLast(first);
                ar.offerFirst(second);
            }
        }
        if (!ar.isEmpty() &&!needSum) {
            ar.offerLast(ar.removeFirst());
        }

        int index = 0;
        int[] result = new int[N];
        while (!ar.isEmpty()) {
            if (!isReverse) {
                result[index++] = ar.removeFirst();
            } else {
                result[N - 1 - index++] = ar.removeFirst();
            }
        }
        return result;
    }
}
