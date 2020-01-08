package com.ctk0327.B1708;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static int N;
    static Dot[] dots;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dots = new Dot[N];
        Dot start = null;
        for (int i = 0; i < N; i++) {
            dots[i] = new Dot(sc.nextInt() , sc.nextInt());
            if (start == null) {
                start = dots[i];
            } else {
                if (start.y > dots[i].y) {
                    start = dots[i];
                }
            }
        }
    }

    static int ccw(Vector vector1, Vector vector2) {
        int result = vector1.x * vector2.y - vector1.y * vector2.x;
        if (result == 0) {
            return 0;
        } else if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        }
        return 0;
    }
}

class Vector{
    Dot start;
    Dot end;
    int x;
    int y;

    public Vector(Dot start, Dot end) {
        this.start = start;
        this.end = end;
        x = end.x - start.x;
        y = end.y - start.y;
    }

}

class Dot implements Comparable<Dot> {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot o) {
        return 0;
    }
}