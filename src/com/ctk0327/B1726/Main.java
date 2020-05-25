package com.ctk0327.B1726;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int input[][];
    static int bfs[][][];
    static int startX, startY, startDirection;
    static int endX, endY, endDirection;
    static Queue<Node> queue;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new int[N + 1][M + 1];
        bfs = new int[N + 1][M + 1][5];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                input[i][j] = sc.nextInt();
                Arrays.fill(bfs[i][j], Integer.MAX_VALUE);
            }
        }

        startX = sc.nextInt();
        startY = sc.nextInt();
        startDirection = sc.nextInt();
        bfs[startX][startY][startDirection] = 0;
        endX = sc.nextInt();
        endY = sc.nextInt();
        endDirection = sc.nextInt();
        queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, startDirection));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int direction = now.direction;

            checkDirection(x, y, direction);

            switch (direction) {
                case 1:
                    for (int i = 1; i < 4; i++) {
                        int nx = x;
                        int ny = y + i;
                        if (1 <= nx && nx <= N && 1 <= ny && ny <= M &&input[nx][ny] == 0) {
                            checkMove(x, y, nx, ny, direction);
                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
                    for (int i = 1; i < 4; i++) {
                        int nx = x;
                        int ny = y - i;
                        if (1 <= nx && nx <= N && 1 <= ny && ny <= M &&input[nx][ny] == 0) {
                            checkMove(x, y, nx, ny, direction);
                        } else {
                            break;
                        }
                    }
                    break;
                case 3:
                    for (int i = 1; i < 4; i++) {
                        int nx = x + i;
                        int ny = y;
                        if (1 <= nx && nx <= N && 1 <= ny && ny <= M &&input[nx][ny] == 0) {
                            checkMove(x, y, nx, ny, direction);
                        } else {
                            break;
                        }
                    }
                    break;
                case 4:
                    for (int i = 1; i < 4; i++) {
                        int nx = x - i;
                        int ny = y;
                        if (1 <= nx && nx <= N && 1 <= ny && ny <= M &&input[nx][ny] == 0) {
                            checkMove(x, y, nx, ny, direction);
                        } else {
                            break;
                        }
                    }
                    break;
            }
        }
        System.out.println(bfs[endX][endY][endDirection]);
    }

    private static void checkDirection(int x, int y, int direction) {
        switch (direction) {
            case 1:
                if (bfs[x][y][direction] + 1 < bfs[x][y][3]) {
                    bfs[x][y][3] = bfs[x][y][direction] + 1;
                    queue.offer(new Node(x, y, 3));
                }
                if (bfs[x][y][direction] + 1 < bfs[x][y][4]) {
                    bfs[x][y][4] = bfs[x][y][direction] + 1;
                    queue.offer(new Node(x, y, 4));
                }
                break;
            case 2:
                if (bfs[x][y][direction] + 1 < bfs[x][y][3]) {
                    bfs[x][y][3] = bfs[x][y][direction] + 1;
                    queue.offer(new Node(x, y, 3));
                }
                if (bfs[x][y][direction] + 1 < bfs[x][y][4]) {
                    bfs[x][y][4] = bfs[x][y][direction] + 1;
                    queue.offer(new Node(x, y, 4));
                }
                break;
            case 3:
                if (bfs[x][y][direction] + 1 < bfs[x][y][1]) {
                    bfs[x][y][1] = bfs[x][y][direction] + 1;
                    queue.offer(new Node(x, y, 1));
                }
                if (bfs[x][y][direction] + 1 < bfs[x][y][2]) {
                    bfs[x][y][2] = bfs[x][y][direction] + 1;
                    queue.offer(new Node(x, y, 2));
                }
                break;
            case 4:
                if (bfs[x][y][direction] + 1 < bfs[x][y][1]) {
                    bfs[x][y][1] = bfs[x][y][direction] + 1;
                    queue.offer(new Node(x, y, 1));
                }
                if (bfs[x][y][direction] + 1 < bfs[x][y][2]) {
                    bfs[x][y][2] = bfs[x][y][direction] + 1;
                    queue.offer(new Node(x, y, 2));
                }
                break;
        }
    }

    private static void checkMove(int x, int y, int nx, int ny, int direction) {
        if (bfs[x][y][direction] + 1 < bfs[nx][ny][direction]) {
            bfs[nx][ny][direction] = bfs[x][y][direction] + 1;
            queue.offer(new Node(nx, ny, direction));
        }
    }
}

class Node {
    int x;
    int y;
    int direction;


    public Node(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
