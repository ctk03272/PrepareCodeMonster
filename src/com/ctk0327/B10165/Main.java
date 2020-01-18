package com.ctk0327.B10165;

import java.util.Scanner;

public class Main {
    static int N,M;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
    }
}
class Line{
    int start;
    int end;
    boolean isCrossZero;

    public Line(int start, int end, boolean isCrossZero) {
        this.start = start;
        this.end = end;
        this.isCrossZero = isCrossZero;
    }
}