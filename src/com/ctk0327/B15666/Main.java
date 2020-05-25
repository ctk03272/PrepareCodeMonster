package com.ctk0327.B15666;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N, M,count;
    static ArrayList<Integer> input;
    static int[] output;
    static int[] checkd;
    static boolean[] visited;
    static StringBuffer sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new ArrayList<>();
        output = new int[M];
        visited = new boolean[8];
        checkd = new int[10001];
        sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int next=sc.nextInt();
            if(checkd[next]==0){
                input.add(next);
            }
            checkd[next]++;
        }
        Collections.sort(input);
        getAnswer(0);
        System.out.println(sb.toString());
    }

    private static void getAnswer(int i) {
        if (i == M) {
            for (int j = 0; j < M; j++) {
                sb.append(output[j] + " ");
            }
            sb.append('\n');
            return;
        }
        for (int j = 0; j < input.size(); j++) {
            if ( i != 0 && output[i - 1] > input.get(j)) {
                continue;
            }
//             && (i != 0 && output[i - 1] > input.get(j))
            checkd[input.get(j)] --;
            output[i] = input.get(j);
            getAnswer(i + 1);
            checkd[input.get(j)] ++;
        }
    }
}
