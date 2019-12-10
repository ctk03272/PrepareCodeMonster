package com.ctk0327.B16947;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int start, end;
    static ArrayList<Integer>[] ar;
    static Queue<Integer> que;
    static int[] visit;
    static boolean[] isJi;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ar = new ArrayList[N + 1];
        que = new LinkedList<>();
        visit = new int[N + 1];
        Arrays.fill(visit,-1);
        isJi=new boolean[N+1];
        sb=new StringBuilder();
        for (int i = 1; i <= N; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            if (ar[start] == null) {
                ar[start] = new ArrayList();
            }
            if (ar[end] == null) {
                ar[end] = new ArrayList();
            }
            ar[start].add(end);
            ar[end].add(start);
        }
        for (int i = 1; i <= N; i++) {
            if (ar[i].size() > 2) {
                que.offer(i);
                visit[i]=0;
            }
        }

        while (!que.isEmpty()) {
            int station = que.poll();
            for (int nextStation : ar[station]) {
                if (station != nextStation && visit[nextStation]!=0) {
                    visit[nextStation]=visit[station]+1;
                    isJi[nextStation]=!isJi[nextStation];
                    que.add(nextStation);
                }
            }
        }
        System.out.println("");
    }
}
