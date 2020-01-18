package com.ctk0327.B2623;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] input;
    static int[] inputDegree;
    static Queue<Integer> searchQue;
    static Queue<Integer> resultQue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        input = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            input[i] = new ArrayList<>();
        }

        inputDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int K = sc.nextInt();
            int[] tempInput = new int[K];
            for (int j = 0; j < K; j++) {
                tempInput[j] = sc.nextInt();
            }
            for (int j = 0; j < K - 1; j++) {
                int start = tempInput[j];
                int end = tempInput[j + 1];
                if (!input[start].contains(end)) {
                    input[start].add(end);
                    inputDegree[end]++;
                }
            }
        }
        topologicalSort();
    }

    private static void topologicalSort() {
        searchQue = new LinkedList<>();
        resultQue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inputDegree[i] == 0) {
                searchQue.offer(i);
            }
        }

        while (!searchQue.isEmpty()) {
            int zeroDegree = searchQue.poll();
            resultQue.offer(zeroDegree);

            for (int linkedNode : input[zeroDegree]) {
                if (--inputDegree[linkedNode] == 0) {
                    searchQue.offer(linkedNode);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (resultQue.size() == N) {
            while (!resultQue.isEmpty()) {
                sb.append(resultQue.poll());
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }else {
            System.out.println("0");
        }
    }
}
