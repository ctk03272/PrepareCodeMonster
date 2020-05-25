package com.ctk0327.B16118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] distance;
    static double[][] distance2;
    static ArrayList<Line>[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = getStingTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new ArrayList[N + 1];
        distance = new int[N + 1];
        distance2 = new double[N + 1][2];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            Arrays.fill(distance2[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= N; i++) {
            input[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = getStingTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            input[start].add(new Line(end, value));
            input[end].add(new Line(start, value));
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((o1, o2) -> (int) (o2.value - o1.value));
        PriorityQueue<Node> priorityQueue2 = new PriorityQueue<Node>((o1, o2) -> {
            if (o2.value > o1.value) {
                return -1;
            } else if (o2.value == o1.value) {
                return 0;
            } else {
                return 1;
            }
        });

        priorityQueue.add(new Node(1, 0));
        priorityQueue2.add(new Node(1, 0, true));
        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();
            int nowPlace = now.index;
            int cost = (int) now.value;
            if (distance[nowPlace] < cost) {
                continue;
            }
            distance[nowPlace] = cost;
            int length = input[nowPlace].size();
            for (int i = 0; i < length; i++) {
                Line line = input[nowPlace].get(i);
                int nextCost = cost + line.value;
                if (distance[line.dest] > nextCost) {
                    priorityQueue.add(new Node(line.dest, nextCost));
                }
            }
        }
        while (!priorityQueue2.isEmpty()) {
            Node now = priorityQueue2.poll();
            int nowPlace = now.index;
            double cost = now.value;
            boolean isDouble = now.isDouble;
            int isDoubleIndex = isDouble ? 0 : 1;
            if (distance2[nowPlace][isDoubleIndex] < cost) {
                continue;
            }
            distance2[nowPlace][isDoubleIndex] = cost;

            int length = input[nowPlace].size();
            for (int i = 0; i < length; i++) {
                Line line = input[nowPlace].get(i);
                double nextCost;
                if (isDouble) {
                    nextCost = (double) line.value / 2 + cost;
                } else {
                    nextCost = line.value * 2 + cost;
                }
                if (distance2[line.dest][isDoubleIndex] > nextCost) {
                    priorityQueue2.add(new Node(line.dest, nextCost, !isDouble));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            double fox = distance[i];
            double wolf = Math.min(distance2[i][0], distance2[i][1]);
            if (fox < wolf) {
                result++;
            }
        }
        System.out.println(result);
    }

    static StringTokenizer getStingTokenizer(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        return st;
    }
}

class Line {
    int dest;
    int value;

    public Line(int dest, int value) {
        this.dest = dest;
        this.value = value;
    }
}

class Node {
    int index;
    double value;
    boolean isDouble;

    public Node(int index, double value, boolean isDouble) {
        this.index = index;
        this.value = value;
        this.isDouble = isDouble;
    }

    public Node(int index, double value) {
        this.index = index;
        this.value = value;
    }
}
