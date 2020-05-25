package com.ctk0327.B2819;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] input;
    static ArrayList<Integer> xs;
    static ArrayList<Integer> ys;
    static int x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        long result = 0;
        x = 0;
        y = 0;
        xs = new ArrayList<>();
        ys = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int tempx = sc.nextInt();
            int tempy = sc.nextInt();
            result += Math.abs(tempx - x);
            result += Math.abs(tempy - y);
            xs.add(tempx);
            ys.add(tempy);
        }
        Collections.sort(xs);
        Collections.sort(ys);
        sc.nextLine();
        String order = sc.nextLine();

        for (int i = 0; i < M; i++) {
            int firstX = getLowerBoundX(0, N);
            int lastX = getUpperBoundX(0, N);
            int numberX = lastX - firstX;
            int firstY = getLowerBoundY(0, N);
            int lastY = getUpperBoundY(0, N);
            int numberY = lastY - firstY;

            char nowOrder = order.charAt(i);
            if (nowOrder == 'S') {
                if (firstY == N) {
                    result += N;
                } else {
                    result += firstY + numberY - (N - lastY);
                }
                y++;
            } else if (nowOrder == 'I') {
                if (firstX == N) {
                    result += N;
                } else {
                    result += firstX + numberX - (N - lastX);
                }
                x++;
            } else if (nowOrder == 'J') {
                if (firstY == N) {
                    result -= N;
                } else {
                    result += -firstY + numberY + (N - lastY);
                }
                y--;
            } else if (nowOrder == 'Z') {
                if (firstX == N) {
                    result -= N;
                } else {
                    result += -firstX + numberX + (N - lastX);
                }
                x--;
            }
            System.out.println(result);
        }
    }

    static int getLowerBoundX(int s, int e) {
        int m;
        while (e - s > 0) {
            m = (s + e) / 2;
            if (xs.get(m) < x) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return e;
    }

    static int getLowerBoundY(int s, int e) {
        int m;
        while (e - s > 0) {
            m = (s + e) / 2;
            if (ys.get(m) < y) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return e;
    }

    static int getUpperBoundX(int s, int e) {
        int m;
        while (e - s > 0) {
            m = (s + e) / 2;
            if (xs.get(m) <= x) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return e;
    }

    static int getUpperBoundY(int s, int e) {
        int m;
        while (e - s > 0) {
            m = (s + e) / 2;
            if (ys.get(m) <= y) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return e;
    }
}
