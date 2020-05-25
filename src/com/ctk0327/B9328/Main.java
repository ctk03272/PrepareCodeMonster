package com.ctk0327.B9328;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static char[][] input;
    static boolean[][] visited;
    static boolean[][] results;
    static boolean[] hasKey;
    static Queue<Pair> q;
    static Queue<Pair> startDoor;
    static boolean isGetKey;
    static int result;
    static final int[] dx = { 0, 0, 1, -1 };
    static final int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T > 0) {
            N = sc.nextInt();
            M = sc.nextInt();
            sc.nextLine();
            q = new LinkedList<>();
            startDoor = new LinkedList<>();
            input = new char[N][M];
            hasKey = new boolean[26];
            visited = new boolean[N][M];
            results = new boolean[N][M];
            result = 0;
            String temp;
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                temp = sc.nextLine();
                for (int j = 0; j < M; j++) {
                    char tempInput = temp.charAt(j);
                    input[i][j] = tempInput;
                    if ((i == 0 || j == 0 || i == N - 1 || j == M - 1) && (tempInput !='*')) {
                        q.offer(new Pair(i, j, tempInput));
                        visited[i][j] = true;
                        if (tempInput == '$') {
                            results[i][j] = true;
                        }
                        if (tempInput >= 97 && tempInput <= 122) {
                            hasKey[tempInput - 97] = true;
                        }
                      /*  if (tempInput >= 65 && tempInput <= 90) {
                            startDoor.offer(new Pair(i,j,tempInput));
                        }*/
                    }
                }
            }
            String keys = sc.nextLine();
            if (!keys.equals("0")) {
                int keyLength = keys.length();
                for (int i = 0; i < keyLength; i++) {
                    hasKey[keys.charAt(i) - 97] = true;
                }
            }

            doSearch();
            while (true) {
                if (isGetKey) {
                    isGetKey = false;
                    visited = new boolean[N][M];
                    while (!startDoor.isEmpty()) {
                        q.offer(startDoor.poll());
                    }
                    doSearch();
                } else {
                    T--;
                    break;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (results[i][j] == true) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void doSearch() {
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;
            char ch = pair.ch;
            if ((input[x][y] >= 65 && input[x][y] <= 90) &&!hasKey[input[x][y]-65]) {
                startDoor.offer(new Pair(x, y, input[x][y]));
            } else {
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
                        if ((input[nx][ny] == '.')) {
                            q.offer(new Pair(nx, ny, input[nx][ny]));
                        } else if (input[nx][ny] >= 65 && input[nx][ny] <= 90) {
                            if (hasKey[input[nx][ny] - 65]) {
                                q.offer(new Pair(nx, ny, input[nx][ny]));
                            } else {
                                startDoor.offer(new Pair(nx, ny, input[nx][ny]));
                            }
                        } else if (input[nx][ny] >= 97 && input[nx][ny] <= 122) {
                            if (!hasKey[input[nx][ny] - 97]) {
                                hasKey[input[nx][ny] - 97] = true;
                                isGetKey = true;
                            }
                            q.offer(new Pair(nx, ny, input[nx][ny]));
                        } else if (input[nx][ny] == '$') {
                            results[nx][ny] = true;
                            q.offer(new Pair(nx, ny, input[nx][ny]));
                        }
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;
    char ch;

    public Pair(int x, int y, char ch) {
        this.x = x;
        this.y = y;
        this.ch = ch;
    }
}
