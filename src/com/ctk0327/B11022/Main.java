package com.ctk0327.B11022;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        int b;
        for (int i = 1; i <= n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.printf("Case #%d: %d + %d = %d", i,a,b, a + b);
            System.out.println();

        }
    }
}