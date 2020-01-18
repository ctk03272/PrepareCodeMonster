package com.ctk0327.B1517;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i]=sc.nextInt();
        }
        System.out.println(solve(input, 0, N - 1));
    }

    private static long solve(int[] given, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int[] temp = new int[end - start + 1];
        long ans = solve(given, start, mid) + solve(given, mid + 1, end);
        int index1 = start;
        int index2 = mid + 1;
        int k = 0;
        while (index1 <= mid || index2 <= end) {
            if (index1 <= mid && (index2 > end || given[index1] <= given[index2])) {
                temp[k++] = given[index1++];
            } else {
                ans += (long) (mid - index1 + 1);
                temp[k++] = given[index2++];
            }
        }
        for (int i = start; i <= end; i++) {
            given[i] = temp[i - start];
        }
        return ans;s
    }
}
