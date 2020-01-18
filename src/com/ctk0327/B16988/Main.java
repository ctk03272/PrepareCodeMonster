package com.ctk0327.B16988;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] input;
    static boolean[][] visit;
    static boolean[][] check;
    static Node f1;
    static Node f2;
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, -0, 1, -1 };
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new int[N][M];
        visit = new boolean[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (input[i][j] == 2 && !visit[i][j]) {
                    visit[i][j] = true;
                    int temp = checkBoundary(new Node(i, j));
                    if (temp > answer) {
                        answer = temp;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static int checkBoundary(Node input2) {
        Queue<Node> queue = new LinkedList<>();
        check = new boolean[N][M];
        queue.offer(input2);
        int result = 0;
        int count = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (input[nx][ny] == 2 && !visit[nx][ny]) {
                        queue.offer(new Node(nx, ny));
                        visit[nx][ny] = true;
                        count++;
                    } else if (input[nx][ny] == 0 && !check[nx][ny]) {
                        if (result == 0) {
                            f1 = new Node(nx, ny);
                        } else if (result == 1) {
                            f2 = new Node(nx, ny);
                        } else {
                            return 0;
                        }
                        result++;
                        check[nx][ny] = true;
                    }
                }
            }
        }
        return count;
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}