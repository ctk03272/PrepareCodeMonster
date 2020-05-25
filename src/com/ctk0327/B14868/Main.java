package com.ctk0327.B14868;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int ans;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        int count = 1;
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (inBorder(nx, ny) && map[nx][ny] != 0) {
                    map[x][y] = map[nx][ny];
                }
            }
            if (map[x][y] == 0) {
                map[x][y] = count++;
            }
        }
        while (!makeOneWorld()) {
            doExtendsion();
            doIntegration();
        }
        System.out.println(ans-1);
    }

    private static void doIntegration() {
        visited = new boolean[N + 1][N + 1];
        Queue<Node> nodes = new LinkedList<>();
        Set<Integer> mapSet=new HashSet<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0 && !mapSet.contains(map[i][j])) {
                    nodes.add(new Node(i,j));
                    mapSet.add(map[i][j]);
                }
            }
        }

        while (!nodes.isEmpty()) {
            Node now = nodes.poll();
            int x = now.x;
            int y = now.y;
            int mapNow=map[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inBorder(nx, ny) && !visited[nx][ny] &&map[nx][ny]!=0 && map[nx][ny]!=mapNow) {
                    map[nx][ny]=mapNow;
                    visited[nx][ny]=true;
                    nodes.add(new Node(nx,ny));
                }
            }
        }
    }

    private static void doExtendsion() {
        visited = new boolean[N + 1][N + 1];
        Queue<Node> nodes = new LinkedList<>();
        Set<Integer> mapSet=new HashSet<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0 && !mapSet.contains(map[i][j])) {
                    nodes.add(new Node(i,j));
                    mapSet.add(map[i][j]);
                }
            }
        }

        while (!nodes.isEmpty()) {
            Node now = nodes.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (inBorder(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[x][y];
                    }else {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[x][y];
                        nodes.add(new Node(nx,ny));
                    }
                }
            }
        }
    }

    private static boolean makeOneWorld() {
        int startCount = 0;
//        visited = new boolean[N + 1][N + 1];
//        Queue<Node> nodes = new LinkedList<>();
        a:
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != startCount) {
                    if (startCount != 0) {
                        ans++;
                        return false;
                    }
                    startCount = map[i][j];
                }
            }
        }
//        while (!nodes.isEmpty()) {
//            Node now = nodes.poll();
//            int x = now.x;
//            int y = now.y;
//
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                if (inBorder(nx, ny))
//            }
//        }
        return true;
    }

    private static boolean inBorder(int nx, int ny) {
        if (1 <= nx && nx <= N && 1 <= ny && ny <= N) {
            return true;
        }
        return false;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
