package com.ctk0327.B1256;

import java.util.Scanner;

public class Main {
    static int N, M, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        int total = getTotal();
    }

    private static int getTotal() {
        int result = 0;
        result = getFactorial(N + M) / (getFactorial(N) * getFactorial(M));
        return result;
    }

    private static int getFactorial(int i) {
        if (i == 1) {
            return 1;
        } else {
            return 1;
        }
    }
}
