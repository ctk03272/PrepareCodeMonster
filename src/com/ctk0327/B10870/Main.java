package com.ctk0327.B10870;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = getPibo(N);
        System.out.println(result);
    }

    private static int getPibo(int n) {
        if (n == 1) {
            return 1;
        } else if(n==0){
            return 0;
        }else{
            return getPibo(n-1)+getPibo(n-2);
        }
    }
}
