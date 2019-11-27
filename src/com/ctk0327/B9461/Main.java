package com.ctk0327.B9461;

import java.util.Scanner;

public class Main {
    static long result[];
    static int input;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        result=new long[101];
        result[1]=1;
        result[2]=1;
        result[3]=1;
        result[4]=2;
        result[5]=2;
        for (int i = 6; i <101 ; i++) {
            result[i]=result[i-1]+result[i-5];
        }
        for (int i = 0; i <N ; i++) {
            input=sc.nextInt();
            System.out.println(result[input]);
        }
    }
}
