package com.ctk0327.B1516;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] lineCnt;
    static ArrayList<Integer>[] ar;
    static int[] cost;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        lineCnt = new int[N + 1];
        ar = new ArrayList[N + 1];
        cost = new int[N + 1];
        answer=new int[N+1];
        for (int i = 1; i <= N; i++) {
            ar[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int nowCost = sc.nextInt();
            cost[i] = nowCost;
            int next;
            while ((next = sc.nextInt()) != -1) {
                ar[next].add(i);
                lineCnt[i]++;
            }
        }
        topologicalSort();
        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (lineCnt[i] == 0) {
                queue.add(i);
                answer[i]=cost[i];
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.remove();

            for (int nextV : ar[v]) {
                lineCnt[nextV]--;
                answer[nextV] = Math.max(answer[v] + cost[nextV],answer[nextV]) ;
                if (lineCnt[nextV] == 0) {
                    queue.add(nextV);
                }
            }
        }
    }
}