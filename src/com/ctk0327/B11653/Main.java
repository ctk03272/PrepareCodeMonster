package com.ctk0327.B11653;

import java.util.Scanner;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        sb=new StringBuilder();
        while(N!=1){
            for (int i = 2; i <=(N) ; i++) {
                if(N%i==0){
                    sb.append(i);
                    sb.append("\n");
                    N=N/i;
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
