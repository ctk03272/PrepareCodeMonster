package com.ctk0327.B1707;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] input;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int index = 1;
            int V = sc.nextInt();
            int E = sc.nextInt();
            input = new ArrayList[V + 1];
            visited = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                input[i] = new ArrayList();
                visited[i] = i;
            }

            for (int i = 1; i <= E; i++) {
                int start = sc.nextInt();
                int to = sc.nextInt();
                input[start].add(to);
                input[to].add(start);
            }
            for (int i = 1; i <= V; i++) {
                Queue<Integer> queue = new LinkedList<>();
                if (!input[i].isEmpty() && visited[i] == i) {
                    queue.add(input[i].get(0));
                }
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    for (Integer next : input[now]) {
                        visited[next] = visited[now];
                    }
                }
            }
            T--;
        }
    }
}
