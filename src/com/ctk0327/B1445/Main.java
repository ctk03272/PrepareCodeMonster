package com.ctk0327.B1445;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Node dp[][];
    static char input[][];
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int trashAnswer, trashSIdeAnswer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        input = new char[N][M];
        dp = new Node[N][M];
        trashAnswer = Integer.MAX_VALUE;

        Queue<Node> queue = new LinkedList<>();
        // input 입력
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                input[i][j] = temp.charAt(j);
                Node node = new Node(i, j);
                if (input[i][j] == 'S') {
                    node.trash = 0;
                    node.trashSide = 0;
                    queue.offer(node);
                } else {
                    node.trash = Integer.MAX_VALUE;
                    node.trashSide = Integer.MAX_VALUE;
                }
                dp[i][j] = node;
            }
        }
        //BFS 시작
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int trash = now.trash;
            int trashSide = now.trashSide;
            if (input[x][y] == 'F') {
                if (dp[x][y].trash < trashAnswer) {
                    trashAnswer = dp[x][y].trash;
                    trashSIdeAnswer = dp[x][y].trashSide;
                } else if (dp[x][y].trash == trashAnswer) {
                    if (trashSIdeAnswer > dp[x][y].trashSide) {
                        trashSIdeAnswer = dp[x][y].trashSide;
                    }
                }
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                trash = now.trash;
                trashSide = now.trashSide;
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (input[nx][ny] == 'g') {
                        Node node = new Node(nx, ny);
//                        (dp[nx][ny].trash > trash + 1 || (dp[nx][ny].trash==trash && dp[nx][ny].trashSide>trashSide)
                        if (dp[nx][ny].trash > trash + 1) {
                            node.trash = trash + 1;
                            node.trashSide = trashSide;
                            dp[nx][ny] = node;
                            queue.offer(node);
                        } else if (dp[nx][ny].trash == trash+1 && dp[nx][ny].trashSide > trashSide) {
                            node.trash = trash+1;
                            node.trashSide = trashSide;
                            dp[nx][ny] = node;
                            queue.offer(node);
                        }
                    } else if (input[nx][ny] != 'g') {
                        Node nextNode = new Node(nx, ny);
                        if (isNextTrash(nx, ny)) {
                            trashSide = trashSide + 1;
                        }
                        if (dp[nx][ny].trash > trash || (dp[nx][ny].trash == trash && dp[nx][ny].trashSide > trashSide)) {
                            nextNode.trash = trash;
                            nextNode.trashSide = trashSide;
                            dp[nx][ny] = nextNode;
                            queue.offer(nextNode);
                        }
                    }
                }
            }
        }

        System.out.printf("%d %d", trashAnswer, trashSIdeAnswer);
    }

    private static boolean isNextTrash(int x, int y) {
        boolean isNextTrash = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < M && input[nx][ny] == 'g' && input[x][y] != 'F' && input[x][y] != 'S' && input[x][y] != 'g') {
                isNextTrash = true;
            }
        }
        return isNextTrash;
    }

}

class Node {
    int x;
    int y;
    int trash;
    int trashSide;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        trashSide = 0;
        trash = 0;
    }
}