package com.ctk0327.B2234;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int input[][];
    static int group[][];
    static boolean visit[][];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static Queue<Node> queue;
    static ArrayList<Node> startGroup;
    static int groupId;
    static ArrayList<Integer> groupSizeList;
    static int maxGroup;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[m][n];
        group = new int[m][n];
        groupSizeList = new ArrayList<>();
        queue = new LinkedList<>();
        startGroup = new ArrayList<>();
        visit = new boolean[m][n];
        groupId = 1;
        max=Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    startGrouping(i, j);
                }
            }
        }

        maxGroup = Integer.MIN_VALUE;
        visit = new boolean[m][n];
        for (int i = 1; i < groupId; i++) {
            getNearestGroup(i);
        }
        System.out.println(groupId-1);
        System.out.println(max);
        System.out.println(maxGroup);
    }

    private static void getNearestGroup(int i1) {
        Node startNode = startGroup.get(i1 - 1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        visit[startNode.x][startNode.y] = true;
        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n && !visit[nx][ny]) {
                    if(group[nx][ny]==i1){
                        visit[nx][ny]=true;
                        queue.add(new Node(nx,ny,i1));
                    }else{
                        int total=groupSizeList.get(i1-1)+groupSizeList.get(group[nx][ny]-1);
                        if(maxGroup<total){
                            maxGroup=total;
                        }
                    }
                }
            }
        }
    }

    private static void startGrouping(int i, int j) {
        queue.add(new Node(i, j, groupId));
        group[i][j] = groupId;
        visit[i][j] = true;
        startGroup.add(new Node(i, j, groupId));
        int groupSize = 1;
        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int nowX = nowNode.x;
            int nowY = nowNode.y;
            int nowGroup = nowNode.group;

            for (int k = 0; k < 4; k++) {
                int nx = nowX + dx[k];
                int ny = nowY + dy[k];
                if (0 <= nx && nx < m && 0 <= ny && ny < n && ((int) Math.pow(2, k) & input[nowX][nowY]) == 0 && !visit[nx][ny]) {
                    queue.add(new Node(nx, ny, groupId));
                    visit[nx][ny] = true;
                    group[nx][ny] = groupId;
                    groupSize++;
                }
            }
        }
        if(max<groupSize){
            max=groupSize;
        }
        groupSizeList.add(groupSize);
        groupId += 1;
    }
}

class Node {
    int x;
    int y;
    int group;

    public Node(int x, int y, int group) {
        this.x = x;
        this.y = y;
        this.group = group;
    }
}
