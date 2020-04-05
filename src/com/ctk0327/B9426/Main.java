package com.ctk0327.B9426;

import java.util.Scanner;

public class Main {
    static int N;
    static int K;
    static int[] tree;
    static int[] input;
    static int MAX = 250001;
    static long answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        input = new int[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        int treeSize = MAX * 3;
        tree = new int[treeSize];
        int m = (K + 1) / 2;

        for (int i = 0; i < K; i++) {
            updateTree(1, input[i], 0, MAX, true);
        }
        answer += getMedian(1, m, 0, MAX);

        for (int i = K; i < N ; i++) {
            updateTree(1, input[i - K], 0, MAX, false);
            updateTree(1, input[i], 0, MAX, true);
            answer += getMedian(1, m, 0, MAX);
        }
        System.out.println(answer);
    }

    private static void updateTree(int index, int num, int l, int r, boolean isADD) {
        if (num >= l && num <= r) {
            if (isADD) {
                tree[index] += 1;
            } else {
                tree[index] -= 1;
            }
        } else {
            return;
        }
        if (l != r) {
            updateTree(2 * (index), num, l, (l + r) / 2, isADD);
            updateTree(2 * (index) + 1, num, (l + r) / 2 + 1, r, isADD);
        }
    }

    private static int getMedian(int index, int d, int start, int end) {
        int mid = (start + end) / 2;

        if (start == end) {
            return start;
        }

        if (tree[index * 2] < d) {
            return getMedian(index * 2 + 1, d - tree[index * 2], mid + 1, end);
        } else {
            return getMedian(index * 2, d, start, mid);
        }
    }
}
