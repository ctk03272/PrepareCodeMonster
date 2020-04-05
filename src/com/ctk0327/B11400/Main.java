package com.ctk0327.B11400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int V, E;
    static ArrayList<Integer>[] input;
    static ArrayList<Node> answer;
    static int[] dfs;
    static int index = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        input = new ArrayList[V + 1];
        dfs = new int[V + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            input[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int from;
            int to;
            from = sc.nextInt();
            to = sc.nextInt();
            input[from].add(to);
            input[to].add(from);
        }
        dfs(1,0);
        for (int i = 1; i <= V; i++) {
            if (dfs[i] != 0) {
                dfs(i, 0);
            }
        }
        Collections.sort(answer, (a, b) -> a.x - b.x);

        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i).x + " " + answer.get(i).y);
        }
    }

    static int dfs(int now, int parent) {
        dfs[now] = index++;
        int result = dfs[now];
        int length = input[now].size();
        for (int i = 0; i < length; i++) {
            int next = input[now].get(i);
            if (next == parent) {
                continue;
            }

            if (dfs[next] == 0) {
                result = Math.min(result, dfs[next]);
                continue;
            }
            int prev = dfs(next, now);
            if (prev > dfs[now]) {
                answer.add(new Node(now, next));
            }
            result = Math.min(result, prev);
        }
        return result;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        if (x < y) {
            this.x = x;
            this.y = y;
        } else {
            this.x = y;
            this.y = x;
        }
    }
}