package com.ctk0327.B3860;

import java.util.Scanner;

public class Main {
    static int W, H, G, E;
    static int[][] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            W = sc.nextInt();
            H = sc.nextInt();
            if (W == 0 && H == 0) {
                break;
            }
            input = new int[W][H];
        }
    }
}
