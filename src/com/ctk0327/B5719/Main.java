package com.ctk0327.B5719;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N, M, S, D;
    static int input[][];
    static int dist[];
    static ArrayList<ArrayList<Integer>> ar2;
    static PriorityQueue<Line> prQue;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Solve.solve();
    }

    static class Solve {
        static boolean getInput() {
            N = sc.nextInt();
            M = sc.nextInt();
            if (N == 0 && M == 0) {
                return true;
            }
            S = sc.nextInt();
            D = sc.nextInt();
            input = new int[N][N];
            dist = new int[N];
            ar2= new ArrayList<>();
            Arrays.fill(dist, Integer.MAX_VALUE);
            prQue = new PriorityQueue<>();
            for (int i = 0; i < M; i++) {
                int start=0, end=0, val=0;
                try {
                    start = sc.nextInt();
                    end = sc.nextInt();
                    val = sc.nextInt();
                    input[start][end] = val;

                } catch (Exception e) {
                }
            }

            for (int i = 0; i < N; i++) {
                ArrayList<Integer> ar = new ArrayList();
                if (i == S) {
                    ar.add(S);
                    prQue.offer(new Line(-1, i, ar, 0));
                    dist[i] = 0;
                } else {
                    prQue.offer(new Line(-1, i, new ArrayList<>(), Integer.MAX_VALUE));
                }
            }
            return false;
        }

        static void solve() {
            while (!getInput()) {

                getMin();

                for (int i = 0; i < ar2.size(); i++) {
                    ArrayList<Integer> arTemp = ar2.get(i);
                    int tempSum = 0;
                    for (int j = 0; j < arTemp.size() - 1; j++) {
                        tempSum += input[arTemp.get(j)][arTemp.get(j + 1)];
                    }
                    if (tempSum == dist[D]) {
                        for (int j = 0; j < arTemp.size() - 1; j++) {
                            input[arTemp.get(j)][arTemp.get(j + 1)] = 0;
                        }
                    }
                }
                dist = new int[N];
                Arrays.fill(dist, Integer.MAX_VALUE);

                for (int i = 0; i < N; i++) {
                    ArrayList<Integer> ar = new ArrayList();
                    if (i == S) {
                        ar.add(S);
                        prQue.offer(new Line(-1, i, ar, 0));
                        dist[i] = 0;
                    } else {
                        prQue.offer(new Line(-1, i, new ArrayList<>(), Integer.MAX_VALUE));
                    }
                }
                ar2 = new ArrayList<>();
                getMin();
                print();
            }
        }

        private static void getMin() {

            while (!prQue.isEmpty()) {
                Line getLine = prQue.poll();
                int previous = getLine.previous;
                int now = getLine.now;
                int value = getLine.value;
                ArrayList prevList = getLine.previousList;

                if (value <= dist[now]) {
                    for (int i = 0; i < N; i++) {
                        if (input[now][i] != 0) {
                            if (value != Integer.MAX_VALUE && dist[i] >= value + input[now][i]) {
                                dist[i] = value + input[now][i];
                                prevList.add(i);
                                if (i == D) {
                                    ar2.add((ArrayList<Integer>) prevList.clone());
                                }
                                prQue.offer(new Line(now, i, (ArrayList<Integer>) prevList.clone(), dist[i]));
                                prevList.remove(prevList.size() - 1);
                            }
                        }
                    }
                }
            }
        }

        private static void print() {
            System.out.println(dist[D] != Integer.MAX_VALUE ? dist[D] : -1);
        }

    }
}

class Line implements Comparable<Line> {
    int previous;
    int now;
    ArrayList<Integer> previousList;
    int value;

    public Line(int previous, int now, ArrayList<Integer> previousList, int value) {
        this.previous = previous;
        this.now = now;
        this.previousList = previousList;
        this.value = value;
    }

    @Override
    public int compareTo(Line o) {
        return this.value - o.value;
    }
}
