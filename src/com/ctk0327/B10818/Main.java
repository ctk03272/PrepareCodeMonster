package com.ctk0327.B10818;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int input;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            input=sc.nextInt();
            if(min>input){
                min=input;
            }
            if(max<input){
                max=input;
            }
        }
        System.out.printf("%d %d",min,max);
    }
}
