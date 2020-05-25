package com.ctk0327.B10282;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int T, n, d, c;
    static int input[][];
    static int dist[];
    static PriorityQueue<Line> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T > 0) {
            n = sc.nextInt();
            d = sc.nextInt();
            c = sc.nextInt();
            input = new int[n + 1][n + 1];
            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            queue = new PriorityQueue<Line>();
            for (int i = 1; i <= d; i++) {
                int start=sc.nextInt();
                int end=sc.nextInt();
                input[end][start] = sc.nextInt();
            }
            for (int i = 1; i <= n; i++) {
                if (i == c) {
                    queue.offer(new Line(-1, i, 0));
                    dist[i] = 0;
                } else {
                    queue.offer(new Line(-1, i, Integer.MAX_VALUE));
                }
            }
            while (!queue.isEmpty()) {
                Line getLine = queue.poll();
                int start = getLine.start;
                int end = getLine.end;
                int value = getLine.value;

                if (value <= dist[end]) {
                    for (int i = 1; i <= n; i++) {
                        if(input[end][i]!=0){
                            if(value!=Integer.MAX_VALUE && dist[i]>value+input[end][i]){
                                dist[i]=value+input[end][i];
                                queue.offer(new Line(end,i,dist[i]));
                            }
                        }
                    }
                }
            }
            int max=Integer.MIN_VALUE;
            int result=0;
            for (int i = 1; i <= n; i++) {
                if(dist[i]!=Integer.MAX_VALUE){
                    result++;
                    if(max<dist[i]){
                        max=dist[i];
                    }
                }
            }
            System.out.println(result+" "+max);
            T--;
        }
    }
}

class Line implements Comparable<Line> {
    int start;
    int end;
    int value;

    public Line(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Line o) {
        return this.value - o.value;
    }
}
