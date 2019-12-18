package com.ctk0327.B2001;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static ArrayList<Bridge>[] bridges;
    static int[] jew;
    static ArrayList<Integer> visit[];
    static Queue<Land> queue;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        bridges = new ArrayList[N + 1];
        jew = new int[N + 1];
        visit = new ArrayList[N + 1];
        queue = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < K; i++) {
            jew[sc.nextInt()] = i + 1;
        }
        int start, end, limit;
        for (int i = 0; i < M; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            limit = sc.nextInt();
            if (bridges[start] == null) {
                bridges[start] = new ArrayList<>();
            }
            if (bridges[end] == null) {
                bridges[end] = new ArrayList<>();
            }
            bridges[start].add(new Bridge(end, limit));
            bridges[end].add(new Bridge(start, limit));
        }
        queue.offer(new Land(1, 1, 0));
        while (!queue.isEmpty()) {
            Land now = queue.poll();
            if (now.now == 1 && result < now.count) {
                result = now.count;
            }
            if (visit[now.now] == null) {
                visit[now.now] = new ArrayList<>();
            }
            visit[now.now].add(now.jew);
            if (jew[now.now] != 0 && (now.jew & (int) Math.pow(2, jew[now.now])) == 0) {
                queue.offer(new Land(now.now, now.jew + (int) Math.pow(2, jew[now.now]), now.count + 1));
            }
            ArrayList<Bridge> ar = bridges[now.now];
            int len = ar.size();
            for (int i = 0; i < len; i++) {
                Bridge bridge = ar.get(i);
                int destEnd = bridge.end;
                int desLimit = bridge.limit;
//                if (desLimit >= now.count && !visit[destEnd][now.jew]) {
                if (desLimit >= now.count) {
                    if (visit[destEnd] == null || !isVisit(destEnd, now.jew)) {
                        queue.offer(new Land(destEnd, now.jew, now.count));
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isVisit(int destEnd, int jew) {
        boolean result = false;
        for (int i = 0; i < visit[destEnd].size(); i++) {
            if (visit[destEnd].get(i) == jew) {
                result = true;
            }
        }
        return result;
    }
}

class Bridge {
    int end;
    int limit;

    public Bridge(int end, int limit) {
        this.end = end;
        this.limit = limit;
    }
}

class Land {
    int now;
    int jew;
    int count;

    public Land(int now, int jew, int count) {
        this.now = now;
        this.jew = jew;
        this.count = count;
    }
}
