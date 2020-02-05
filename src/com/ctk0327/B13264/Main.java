package com.ctk0327.B13264;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int T;
    static String input;
    static int N;
    static int maxN;
    static char[] inputChar;
    static int[] group, tempGroup;
    static Integer[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        N = input.length();
        maxN = 2000000;
        group = new int[maxN];
        Arrays.fill(group, -1);
        answer = new Integer[N];
        tempGroup = new int[maxN];
        inputChar = input.toCharArray();
        getSufixArray();
        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void getSufixArray() {
        T = 1;
        for (int i = 0; i < N; i++) {
            answer[i] = i;
            group[i] = inputChar[i] - 'a';
        }
        while (T <= N) {
            Arrays.sort(answer, (o1, o2) -> {
                if (group[o1] == group[o2]) {
                    return Integer.compare(group[o1 + T], group[o2 + T]);
                }
                return Integer.compare(group[o1], group[o2]);
            });
            tempGroup[answer[0]] = 0;
            for (int i = 1; i < N; i++) {
                if (cmp(answer[i - 1], answer[i]) != 0) {
                    tempGroup[answer[i]] = tempGroup[answer[i - 1]] + 1;
                } else {
                    tempGroup[answer[i]] = tempGroup[answer[i - 1]];
                }
            }
            for (int i = 0; i < N; i++) {
                group[i] = tempGroup[i];
            }
            T <<= 1;
        }
    }

    static int cmp(int x, int y) {
        if (group[x] == group[y]) {
            return Integer.compare(group[x + T], group[y + T]);
        }
        return Integer.compare(group[x], group[y]);
    }
}
