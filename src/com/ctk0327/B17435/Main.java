package com.ctk0327.B17435;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int m;
    static int[] fun;
    static int Q;
    static int n, x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        m = sc.nextInt();
        fun = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            fun[i]=sc.nextInt();
        }
        Q=sc.nextInt();
        for (int i = 0; i < Q; i++) {
            n=sc.nextInt();
            x=sc.nextInt();
            sb.append(getResult(n,x));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int getResult(int inputN, int inputX) {
        if(inputN==1){
            return fun[inputX];
        }else{
            return getResult(inputN-1,fun[inputX]);
        }
    }
}
