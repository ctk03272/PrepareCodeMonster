package com.ctk0327.B17244;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int needTake;
    static char input[][];
    static boolean visit[][][];
    static Queue<Node> nodes;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, -0, 1, -1 };
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();
        input = new char[N][M];
        needTake = 0;
        nodes = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                char nextInput = temp.charAt(j);
                input[i][j] = nextInput;
                if (nextInput == 'X') {
                    needTake++;
                } else if (nextInput == 'S') {
                    nodes.offer(new Node(i, j, new ArrayList<>(), 0));

                }
            }
        }

        a:while (!nodes.isEmpty()) {
            Node now = nodes.poll();
            int nowX = now.x;
            int nowY = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                ArrayList<Node> umb = now.umb;
                int count = now.count;
                if (0 <= nx && nx < N && 0 <= ny && ny < M
                    && input[nx][ny] != '#'){
                    if (input[nx][ny] == 'E' && umb.size() == needTake) {
                        if (count + 1 < answer) {
                            answer = count + 1;
                            continue a;
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                ArrayList<Node> umb = now.umb;
                int count = now.count;
                if (0 <= nx && nx < N && 0 <= ny && ny < M
                    && input[nx][ny] != '#') {
                    if (input[nx][ny] == 'X') {
                        if (!now.umb.contains(new Node(nx, ny, null, 0))) {
                            ArrayList<Node> ar = new ArrayList<>();
                            ar.addAll(umb);
                            ar.add(new Node(nx, ny, null, 0));
                            nodes.offer(new Node(nx, ny, ar, count + 1));
                        } else {
                            nodes.offer(new Node(nx, ny, umb, count + 1));
                        }
                    } else if (input[nx][ny] == '.') {
                        nodes.offer(new Node(nx, ny, umb, count + 1));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

class Node {
    int x;
    int y;
    ArrayList<Node> umb;
    int count;

    public Node(int x, int y, ArrayList<Node> umb, int count) {
        this.x = x;
        this.y = y;
        this.umb = umb;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        final Node node = (Node) o;
        return x == node.x &&
               y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, umb, count);
    }
}
