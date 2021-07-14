package com.ctk0327.B12015;

import java.util.*;

public class Main {
    static int N;
    static int[] input;
    static ArrayList<Integer> maxValue;
    static int result = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        maxValue = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
//        for (int i = 0; i < N; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (input[i] > input[j] && dp[i]<=dp[j]) {
//                    dp[i] = dp[j] + 1;
//                    if (dp[i] > result) {
//                        result = dp[i];
//                    }
//                }
//            }
//        }
//
//        System.out.println(result);

        for (int i = 0; i < N; i++) {
            int now = input[i];
            if (maxValue.size() == 0) {
                maxValue.add(now);
            } else if (maxValue.get(0) >= now) {
                maxValue.set(0, now);
            } else if (maxValue.get(maxValue.size() - 1) < now) {
                maxValue.add(maxValue.size(), now);
            } else {
                int index = upperBound(maxValue, maxValue.size()-1, now-1);
                maxValue.set(index, now);
            }

        }
        System.out.println(maxValue.size());
    }

    static int upperBound(List<Integer> list, int n, int k) {
        int start = 0;
        int end = n;
        int mid;

        while (end - start > 0) {
            mid = (start + end) / 2;

            if (list.get(mid) <= k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
