package com.ctk0327;

import java.util.Scanner;

public class B1941 {
    static char[][] input;
    static boolean[] visited;
    static boolean[][] map;
    static int ans;
    static int checkCount;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String temp = sc.next();
            for (int j = 0; j < 5; j++) {
                input[i][j] = temp.charAt(j);
            }
        }
        for (int i = 0; i < 25; i++) {
            visited = new boolean[25];
            map = new boolean[5][5];
            dfs(i, 1, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int i, int count, int s) {
        if (input[i / 5][i % 5] == 'S') {
            s = s + 1;
        }
        visited[i] = true;
        map[i / 5][i % 5] = true;
        if (count == 7) {
            if (s >= 4) {
                for (int j = 0; j < 25; j++) {
                    if (visited[j]) {
                        int x = j / 5;
                        int y = j % 5;
                        boolean[][] check = new boolean[5][5];
                        check[x][y] = true;
                        checkCount=1;
                        check(x, y, check);
                        break;
                    }
                }
            }
        } else {
            for (int j = i + 1; j < 25; j++) {
                if (!visited[j]) {
                    dfs(j, count + 1, s);
                }
            }
        }
        visited[i] = false;
        map[i / 5][i % 5] = false;
    }

    private static void check(int x, int y, boolean[][] check) {
        if(checkCount==7){
            ans++;
        }else {
            for (int i = 0; i <4 ; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                    if (map[nx][ny] && !check[nx][ny]) {
                        check[nx][ny] = true;
                        ++checkCount;
                        check(nx, ny, check);
                    }
                }
            }
        }
    }
}
