package com.ctk0327.B2933;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R, C;
    static int N;
    static char[][] input;
    static boolean[][] visited;
    static ArrayList<Node> ar;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        input = new char[R][C];
        sc.nextLine();
        for (int i = 0; i < R; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < C; j++) {
                input[i][j] = temp.charAt(j);
            }
        }

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int height = sc.nextInt();
            int convertHeight = R - height;
            visited = new boolean[R][C];
            if (i % 2 == 0) {
                for (int j = 0; j < C; j++) {
                    if (input[convertHeight][j] == 'x') {
                        input[convertHeight][j] = '.';
                        break;
                    }
                }
                solve();
            } else {
                for (int j = C - 1; j >= 0; j--) {
                    if (input[convertHeight][j] == 'x') {
                        input[convertHeight][j] = '.';
                        break;
                    }
                }
                solve();
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                sb.append(input[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solve() {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < C; i++) {
            if (input[R - 1][i] == 'x') {
                queue.add(new Node(R - 1, i));
                visited[R - 1][i] = true;
            }
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < R && 0 <= ny && ny < C && visited[nx][ny] == false
                    && input[nx][ny] == 'x') {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        ar = new ArrayList<Node>();

        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && input[i][j] == 'x') {
                    input[i][j] = '.';
                    ar.add(new Node(i, j));
                }
            }
        }
        if(ar.size()==0){
            return;
        }
        a:while(true){
            for (int j = 0; j < ar.size(); j++) {
                int x = ar.get(j).x+1;
                int y = ar.get(j).y;
                    if (0 <= x && x < R && input[x][y] == '.') {

                    } else {
                        break a;
                    }
            }
            for (int i = 0; i < ar.size(); i++) {
                ar.get(i).x=ar.get(i).x+1;
            }
        }

        for (int i = 0; i < ar.size(); i++) {
            input[ar.get(i).x][ar.get(i).y]='x';
        }
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
