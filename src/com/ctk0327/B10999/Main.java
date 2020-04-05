package com.ctk0327.B10999;

import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[] input;
    static long[] tree;
    static long[] lazy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        input = new int[N];
        int h = (int) Math.ceil(Math.log10(N)/Math.log10(2));
        int tree_size = (1 << (h + 1)) - 1;
        lazy = new long[tree_size];
        tree = new long[tree_size];
        M += K;

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        init(input, tree, 1, 0, N - 1);
        while (M-- > 0) {
            int temp1;
            temp1 = sc.nextInt();
            if (temp1 == 1) {
                int start, end;
                long value;
                start = sc.nextInt();
                end = sc.nextInt();
                value = sc.nextInt();
                update_range(tree, lazy, 1, 0, N - 1, start - 1, end - 1, value);
            } else if (temp1 == 2) {
                int start, end;
                start=sc.nextInt();
                end=sc.nextInt();
                long result=sum(tree, lazy, 1, 0, N-1, start-1, end-1);
                System.out.println(result);
            }
        }
    }

    private static void update_range(long[] tree, long[] lazy, int node, int start, int end, int left,
                                     int right, long diff) {
        update_lazy(tree, lazy, node, start, end);
        if (left > end || right < start) {
            return;
        }
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * diff;
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }
        update_range(tree, lazy, node * 2, start, (start + end) / 2, left, right, diff);
        update_range(tree, lazy, node * 2 + 1, (start + end) / 2 + 1, end, left, right, diff);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long sum(long[] tree, long[] lazy, int node, int start, int end, int left, int right) {
        update_lazy(tree, lazy, node, start, end);
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        return sum(tree, lazy, node * 2, start, (start + end) / 2, left, right) + sum(tree, lazy, node * 2 + 1,
                                                                                      (start + end) / 2 + 1,
                                                                                      end, left, right);
    }

    private static void update_lazy(long[] tree, long[] lazy, int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private static long init(int[] input, long[] tree, int node, int start, int end) {
        if (start == end) {
            return (tree[node] = input[start]);
        } else {
            return tree[node] = init(input, tree, node * 2, start, (start + end) / 2) + init(input, tree,
                                                                                             node * 2 + 1,
                                                                                             ((start + end) / 2)
                                                                                             + 1, end);
        }
    }
}
