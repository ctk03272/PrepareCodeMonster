package com.ctk0327.B14888;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] input;
    static int[] calc;
    static int[] calcIn;
    static int[] output;
    static int count = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N + 1];
        calc = new int[5];
        calcIn = new int[5];

        for (int i = 1; i <= N; i++) {
            input[i] = sc.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            int temp = sc.nextInt();

            calcIn[i] = temp;
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {

                calc[j] = calcIn[j];
            }

            output = new int[N + 1];
            output[1] = i;
            if (calc[i] != 0) {
                calc[i]--;
                dfs(2);
            }
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int number) {
        if (number >= N) {
            checkMinMax();
        } else {
            for (int i = 1; i <= 4; i++) {
                output[number] = i;
                if (calc[i] != 0) {
                    calc[i]--;
                    if (isPossible(number)) {
                        dfs(number + 1);
                    }
                    output[number] = 0;
                    calc[i]++;
                } else {
                    output[number] = 0;
                }
            }
        }
    }

    private static boolean isPossible(int number) {

        return true;
    }

    private static void checkMinMax() {
        count++;
        int value = input[1];
        for (int i = 1; i < N; i++) {
            switch (output[i]) {
                case 1:
                    value += input[i + 1];
                    break;
                case 2:
                    value -= input[i + 1];
                    break;
                case 3:
                    value *= input[i + 1];
                    break;
                case 4:
                    value /= input[i + 1];
                    break;
                default:
                    break;
            }
        }
        if (value > max) {
            max = value;
        }
        if (value < min) {
            min = value;
        }
    }
}
