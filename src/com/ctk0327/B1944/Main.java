package com.ctk0327.B1944;

import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] input;
  public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
  }
}
class Node{
    int x;
    int y;
    String value;

    public Node(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
class Line{
    Node start;
    Node end;
    int value;
    public Line(Node start, Node end, int value) {
        this.start = start;
        this.end = end;
        this.value=value;
    }
}