package com.ctk0327.B1944;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][] input;
    static int[] parent;
    static ArrayList<Node> ar;
    static ArrayList<Line> lines;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int result = 0;
    static boolean isMakeIt = false;
    static boolean chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        ar = new ArrayList<>();
        lines = new ArrayList<>();
        input = new char[N][N];
        parent = new int[M + 2];
        int number = 50;
        for (int i = 1; i <= M + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < N; j++) {
                input[i][j] = temp.charAt(j);
                if (input[i][j] == 'S' || input[i][j] == 'K') {
                    if (input[i][j] == 'S') {
                        ar.add(new Node(i, j, 1));
                    }
                    if (input[i][j] == 'K') {
                        input[i][j] = (char) number;
                        ar.add(new Node(i, j, number++ - 48));
                    }
                }
            }
        }
        int arLength = ar.size();
        for (int i = 0; i < arLength; i++) {
            makeLine(ar.get(i));
        }

        lines.sort((a, b) -> a.value - b.value);

        for (int i = 0; i < lines.size(); i++) {
            merge(lines.get(i).start.number, lines.get(i).end.number);
            if (chk) {
                result += lines.get(i).value;
            }
        }
        if (isMakeIt) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    static void makeLine(Node start) {
        int count = 0;
        int startX = start.x;
        int startY = start.y;
        input[startX][startY] = '0';
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[startX][startY] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && '1' != input[nx][ny]
                    && dist[nx][ny] > dist[x][y] + 1) {
                    Node next = new Node(nx, ny, input[nx][ny] - 48);
                    dist[nx][ny] = dist[x][y] + 1;
                    if (input[nx][ny] != '0') {
                        lines.add(new Line(start, next, dist[nx][ny]));
                    }
                    if (start.number == 1 && input[nx][ny] != '0') {
                        count++;
                    }
                    queue.offer(next);
                }
            }
        }
        if(start.number==1 && count==M){
            isMakeIt=true;
        }
    }

    static int find(int u) {
        if (u == parent[u]) { return u; }
        return parent[u] = find(parent[u]);
    }

    static void merge(int u, int v) {
        chk = false;
        u = find(u);
        v = find(v);
        // 사이클 존재 여부 확인 코드
        if (u == v) { return; }
        parent[u] = v;
        chk = true;
    }
}

class Node {
    int x;
    int y;
    int number;

    public Node(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }
}

class Line {
    Node start;
    Node end;
    int value;

    public Line(Node start, Node end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}