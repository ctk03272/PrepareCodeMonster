package com.ctk0327.B14267;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static ArrayList<Integer> input[];
    static long output[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new ArrayList[N + 1];
        output = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            int high = sc.nextInt();
            if (high == -1) {
                continue;
            }
            if(input[high]==null){
                input[high]=new ArrayList<Integer>();
            }
            input[high].add(i);
        }
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int press = sc.nextInt();
            getPress(target, press);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(output[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void getPress(int target, int press) {
        output[target] += press;
        if (input[target]==null || input[target].size()==0) {
            return;
        }
        for (Integer integer:input[target]) {

            getPress(integer, press);
        }
    }
}
