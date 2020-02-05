package com.ctk0327.B1445;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Trash dp[][];
    static char input[][];
    static int N, M;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int trashAnswer, trashSIdeAnswer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        input = new char[N][M];
        dp = new Trash[N][M];
        trashAnswer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], new Trash(Integer.MAX_VALUE,Integer.MAX_VALUE));
        }
        Queue<Node> queue = new LinkedList<>();
        // input 입력
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                input[i][j] = temp.charAt(j);
                if (input[i][j] == 'S') {
                    queue.offer(new Node(i, j));
                    dp[i][j] = new Trash(0,0);
                }
            }
        }
        //BFS 시작
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int trashSide = now.trashSide;
            if (input[x][y] == 'F') {
                if (dp[x][y].trash < trashAnswer) {
                    trashAnswer = dp[x][y].trash;
                    trashSIdeAnswer = trashSide;
                } else if (dp[x][y].trash == trashAnswer) {
                    if (trashSIdeAnswer > trashSide) {
                        trashSIdeAnswer = trashSide;
                    }
                }
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (input[nx][ny] == 'g' && dp[nx][ny].trash > dp[x][y].trash + 1) {
                        dp[nx][ny] = new Trash(dp[x][y].trash + 1,dp[x][y].trashSide);
                        queue.offer(new Node(nx, ny));
                    } else if (input[nx][ny] != 'g') {
                        Node nextNode = new Node(nx, ny);
                        if (isNextTrash(nx, ny)) {
                            nextNode.trashSide = trashSide + 1;
                        }
                        if (dp[nx][ny].trash > dp[x][y].trash) {
                            dp[nx][ny] = new Trash(dp[x][y].trash,nextNode.trashSide);
                            queue.offer(nextNode);
                        }else if(dp[nx][ny].trash==dp[x][y].trash && dp[nx][ny].trashSide>nextNode.trashSide){
                            dp[nx][ny] = new Trash(dp[x][y].trash,nextNode.trashSide);
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
            if (0 <= nx && nx < N && 0 <= ny && ny < M && input[nx][ny] == 'g' && input[x][y]!='F' && input[x][y]!='S' && input[x][y]!='g') {
                isNextTrash = true;
            }
        }
        return isNextTrash;
    }

}

class Node {
    int x;
    int y;
    int trashSide;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        trashSide = 0;
    }
}
class Trash{
    int trash;
    int trashSide;

    public Trash(int trash, int trashSide) {
        this.trash = trash;
        this.trashSide = trashSide;
    }
}
