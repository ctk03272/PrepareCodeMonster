package com.ctk0327.B1967;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayList<Edge2>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Edge2>();
        }
        for (int i = 2; i <= N; i++) {
            String temp = sc.nextLine();
            String input[] = temp.split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            list[from].add(new Edge2(to, cost));
            list[to].add(new Edge2(from, cost));
        }
        int[] dist = bfs(N, list, 1);
        int start = 1;
        for (int i = 2; i <= N; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = bfs(N, list, start);
        int ans = dist[1];
        for (int i = 2; i <= N; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);

    }

    private static int[] bfs(int n, ArrayList<Edge2>[] list, int i) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> que = new LinkedList<>();
        check[i] = true;
        que.add(i);
        while (!que.isEmpty()) {
            int x = que.remove();
            for (Edge2 edge : list[x]) {
                int to = edge.to;
                int cost = edge.cost;
                if (check[to] == false) {
                    dist[to] = dist[x] + cost;
                    que.add(to);
                    check[to] = true;
                }
            }
        }
        return dist;
    }
}

class Edge2 {
    int to;
    int cost;

    public Edge2(int to, int cost) {
        super();
        this.to = to;
        this.cost = cost;
    }

}