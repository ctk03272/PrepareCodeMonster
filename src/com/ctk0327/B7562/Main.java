package com.ctk0327.B7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int T, l;
    static Dot start, dest;
    static Scanner sc;
    static boolean[][] visited;
    static int result;
    static int[] dx = { 2, 2, 1, 1, -1, -1, -2, -2 };
    static int[] dy = { 1, -1, 2, -2, 2, -2, 1, -1 };

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T > 0) {
            solve();
            System.out.println(result);
            T--;
        }
    }

    private static void solve() {
        result = 0;
        l = sc.nextInt();
        visited = new boolean[l][l];
        Queue<Dot> que = new LinkedList<>();
        start = new Dot(sc.nextInt(), sc.nextInt(), 0);
        visited[start.x][start.y]=true;
        que.add(start);
        dest = new Dot(sc.nextInt(), sc.nextInt());
        //BFS를 통하여 방문하지 않은곳을 방문해 가면서 최소거리에 방문할 수 있는 경우의 수를 구한다.
        while (!que.isEmpty()) {
            Dot now = que.poll();
            int x = now.x;
            int y = now.y;
            int step = now.step;
            if (x == dest.x && y == dest.y) {
                result = step;
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isInside(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny]=true;
                    que.add(new Dot(nx, ny, step + 1));
                }
            }
        }

    }
    //체스판을 넘어가지 않는지 확인한다.
    private static boolean isInside(int x, int y) {
        boolean isInside = false;
        if (0 <= x && x < l && 0 <= y && y < l) {
            isInside = true;
        }
        return isInside;
    }
}

class Dot {
    int x;
    int y;
    int step;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Dot(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}