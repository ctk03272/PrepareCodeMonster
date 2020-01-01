package com.ctk0327.B1102;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int P;
    static int visit;
    static int input[][];
    static String onOff;
    static Queue<Node> queue;
    static int cost[];
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[17][17];
        queue = new LinkedList<>();
        cost = new int[17];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        Arrays.fill(cost, Integer.MAX_VALUE);
        sc.nextLine();
        onOff = sc.nextLine();
        int onOffLength = onOff.length();
        for (int i = 0; i < onOffLength; i++) {
            if (onOff.charAt(i) == 'Y') {
                queue.add(new Node((i + 1), 0, i + 1, 1));
                cost[1] = 0;
            }
        }

        P = sc.nextInt();
        result = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int visited = now.visited;
            int cost = now.cost;
            int prev = now.now;
            int fixed = now.fixed;
            for (int i = 1; i <= N; i++) {
                int getVisited;
                if (((visited & (getVisited=getVisited(i))) == 0 && fixed <= P)) {
                    int costSum = cost + input[prev][i];
                    if (costSum < result && fixed >= P) {
                        result = costSum;
                    } else {
                        queue.offer(new Node(visited | getVisited, costSum, i, fixed + 1));
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static int getVisited(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= N; j++) {
            if (i == j) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return Integer.valueOf(sb.reverse().toString(), 2);
    }
}

class Node {
    int visited;
    int cost;
    int now;
    int fixed;

    public Node(int visited, int cost, int now, int number) {
        this.visited = visited;
        this.cost = cost;
        this.now = now;
        this.fixed = number;
    }
}
