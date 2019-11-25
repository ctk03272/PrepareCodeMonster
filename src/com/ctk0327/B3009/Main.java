package com.ctk0327.B3009;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SquarePoint point1 = new SquarePoint(sc.nextInt(), sc.nextInt());
        SquarePoint point2 = new SquarePoint(sc.nextInt(), sc.nextInt());
        SquarePoint point3 = new SquarePoint(sc.nextInt(), sc.nextInt());
        int x = 0, y = 0;
        if (point1.isOppoiste(point2, point3)) {
            x = point2.x + point3.x - point1.x;
            y = point2.y + point3.y - point1.y;
        } else if (point2.isOppoiste(point3, point1)) {
            x = point3.x + point1.x - point2.x;
            y = point1.y + point3.y - point2.y;
        } else if (point3.isOppoiste(point1, point2)) {
            x = point1.x + point2.x - point3.x;
            y = point1.y + point2.y - point3.y;
        }
        System.out.printf("%d %d", x, y);
    }

}

class SquarePoint {
    int x;
    int y;

    public boolean isOppoiste(SquarePoint point1, SquarePoint point2) {
        if ((x - point1.x) * (x - point2.x) + (y - point1.y) * (y - point2.y) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public SquarePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}