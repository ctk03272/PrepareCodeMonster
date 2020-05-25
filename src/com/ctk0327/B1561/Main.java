package com.ctk0327.B1561;

import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] input;
    static long left, right;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new int[M];
        for (int i = 0; i < M; i++) {
            input[i] = sc.nextInt();
        }

        if (N <= M) {
            System.out.println(N);
            return;
        }

        left = 0;
        right = 2000000000L * 1000000L;

        while (left <= right) {
            long mid = (left + right) / 2;
            long begin, end;
            begin = end = 0;
            end = M;
            for (int i = 0; i < M; i++) {
                end += mid / input[i];
            }
            begin=end;
            for (int i = 0; i < M; i++) {
                if (mid % input[i] == 0) {
                    begin -= 1;
                }
            }
            begin += 1;

            if (N < begin) {
                right = mid - 1;
            } else if (N > end) {
                left = mid + 1;
            } else {
                for (int i = 0; i < M; i++) {
                    if (mid % input[i] == 0) {
                        if (N == begin) {
                            System.out.println(i + 1);
                            return;
                        }
                        begin += 1;
                    }
                }
            }
        }
    }
}
