package com.ctk0327.B16954;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] input;
    static int N = 8;
    static int result;
    static boolean isEnd;
    static int[][] wallLocate;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1, 0};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1, 0};
    static Queue<Block> wallQueue;
    static Queue<Character> characterQueue;
    static int maxTime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = new char[N][N];
        wallLocate = new int[N][N];
        maxTime = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            Arrays.fill(wallLocate[i], 0);
        }

        isEnd = false;
        wallQueue = new LinkedList<>();
        characterQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < N; j++) {
                input[i][j] = temp.charAt(j);
                if (input[i][j] == '#') {
                    wallQueue.offer(new Block(i, j, 0));
                    wallLocate[i][j] = 1;
                }
            }
        }
        characterQueue.add(new Character(N - 1, 0));
        moveWall();

        moveCharacter();
        result = isEnd ? 1 : 0;
        System.out.println(result);
    }

    private static void moveWall() {
        while (!wallQueue.isEmpty()) {
            Block now = wallQueue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowTime = now.time;
            int n = nowX + 1;
            if (n == N - 1 && nowTime > maxTime) {
                maxTime = nowTime;
            }
            if (0 <= n && n < N) {
                wallLocate[n][nowY] = wallLocate[n][nowY] | (int) Math.pow(2, nowTime + 1);
                wallQueue.add(new Block(n, nowY, nowTime + 1));
            }
        }
    }

    private static void moveCharacter() {
        while (!characterQueue.isEmpty()) {
            Character now = characterQueue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowTime = now.time;
            for (int i = 0; i < 9; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && ((int) Math.pow(2, nowTime) & wallLocate[nx][ny]) == 0 && ((int) Math.pow(2, nowTime + 1) & wallLocate[nx][ny]) == 0) {
                    if (nx == N - 1 && ny == N - 1) {
                        isEnd = true;
                        return;
                    } else {
                        if (nowTime + 1 > maxTime) {
                            isEnd = true;
                            return;
                        }
                        characterQueue.add(new Character(nx, ny, nowTime + 1));
                    }
                }
            }
        }
    }
}

class Character {
    int x;
    int y;
    int time;

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        time = 0;
    }

    public Character(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

class Block {
    int x;
    int y;
    int time;

    public Block(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}