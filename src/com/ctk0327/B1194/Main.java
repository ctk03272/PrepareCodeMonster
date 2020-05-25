package com.ctk0327.B1194;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static char[][] input;
    static boolean[][][] visit;
    static Queue<Node> start;
    static int result = -1;
    static final int[] dx = { 0, 0, 1, -1 };
    static final int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        visit = new boolean[N][M][64];
        input = new char[N][M];
        start = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                char thisChar = temp.charAt(j);
                if (thisChar == '0') {
                    start.add(new Node(i, j, 0, 0));
                    visit[i][j][0] = true;
                }
                input[i][j] = thisChar;
            }
        }
        while (!start.isEmpty()) {
            Node node = start.poll();
            int x = node.x;
            int y = node.y;
            int val = node.val;
            int key = node.key;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if ((0 <= nx && nx < N && 0 <= ny && ny < M) && !visit[nx][ny][key]) {
                    visit[nx][ny][key] = true;
                    if (input[nx][ny] == '.' || input[nx][ny] == '0') {
                        start.offer(new Node(nx, ny, val + 1, key));
                    } else if (input[nx][ny] >= 'a' && input[nx][ny] <= 'f') {
                        start.offer(new Node(nx, ny, val + 1, key | keyMapping(input[nx][ny])));
                    } else if (input[nx][ny] >= 'A' && input[nx][ny] <= 'F') {
                        if (hasKey(key, input[nx][ny])) {
                            start.offer(new Node(nx, ny, val + 1, key));
                        }
                    } else if (input[nx][ny] == '#') {
                        continue;
                    } else if (input[nx][ny] == '1') {
                        if (result==-1 || result > val + 1) {
                            result = val + 1;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static boolean hasKey(int nowKey, char door) {
        if ((nowKey & doorMapping(door)) != 0) {
            return true;
        } else {
            return false;
        }
    }

    static int doorMapping(char key) {
        switch (key) {
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 4;
            case 'D':
                return 8;
            case 'E':
                return 16;
            case 'F':
                return 32;
        }
        return -1;
    }

    static int keyMapping(char key) {
        switch (key) {
            case 'a':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 4;
            case 'd':
                return 8;
            case 'e':
                return 16;
            case 'f':
                return 32;
        }
        return -1;
    }
}

class Node {
    int x;
    int y;
    int val;
    int key;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public Node(int x, int y, int val, int key) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.key = key;
    }
}
