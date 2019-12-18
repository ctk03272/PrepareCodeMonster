package com.ctk0327.B16235;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[] foodList[];
    static int[] A[];
    static PriorityQueue<Integer>[] prq[];
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        foodList = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];
        prq = new PriorityQueue[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = sc.nextInt();
                prq[i][j] = new PriorityQueue<>();
                foodList[i][j] = 5;
            }
        }
        for (int i = 0; i < M; i++) {
            prq[sc.nextInt()][sc.nextInt()].offer(sc.nextInt());
        }
        for (int i = 0; i < M; i++) {
        }

        for (int i = 0; i < K; i++) {
            springAndSummer();
            fall();
            winter();
        }
        System.out.println(getResult());
    }

    private static int getResult() {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += prq[i][j].size();
            }
        }
        return result;
    }

    private static void springAndSummer() {
        PriorityQueue<Integer> trees;
        PriorityQueue<Integer> newTrees;
        int treeLength;
        int nowTree, food, makeFood;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                newTrees = new PriorityQueue<>();
                trees = prq[i][j];
                treeLength = trees.size();
                makeFood = 0;
                for (int k = 0; k < treeLength; k++) {
                    food = foodList[i][j];
                    nowTree = trees.poll();
                    if (nowTree <= food) {
                        foodList[i][j]=food-nowTree;
                        newTrees.offer(++nowTree);
                    } else {
                        makeFood += nowTree / 2;
                    }
                }
                prq[i][j] = newTrees;
                foodList[i][j] += makeFood;
            }
        }
    }

    private static void fall() {
        PriorityQueue<Integer> trees;
        PriorityQueue<Integer> newTrees;
        int treeLength;
        int nowTree;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                newTrees = new PriorityQueue<>();
                trees = prq[i][j];
                treeLength = trees.size();
                for (int k = 0; k < treeLength; k++) {
                    nowTree = trees.remove();
                    if (nowTree % 5 == 0) {
                        for (int l = 0; l < 8; l++) {
                            int nx = i + dx[l];
                            int ny = j + dy[l];
                            if (0 < nx && nx <= N && 0 < ny && ny <= N) {
                                prq[nx][ny].offer(1);
                            }
                        }
                    }
                    newTrees.offer(nowTree);
                }
                prq[i][j] = newTrees;
            }
        }
    }

    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                foodList[i][j] += A[i][j];
            }
        }
    }
}
