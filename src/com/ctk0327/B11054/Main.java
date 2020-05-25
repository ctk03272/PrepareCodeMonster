package com.ctk0327.B11054;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] input;
    static int[] increase;
    static int[] decrease;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N + 1];
        increase = new int[N + 1];
        decrease = new int[N + 1];
        max=Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            input[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            increase[i]=1;
            for (int j = 1; j <i ; j++) {
                if(input[j]<input[i]&& increase[i]<increase[j]+1){
                    increase[i]=increase[j]+1;
                }
            }
        }
        for (int i = N; i >= 1; i--) {
            decrease[i]=1;
            for (int j = N; j >i ; j--) {
                if(input[j]<input[i]&& decrease[i]<decrease[j]+1){
                    decrease[i]=decrease[j]+1;
                }
            }
        }

        for (int i = 1; i <=N ; i++) {
            if(max<increase[i]+decrease[i]-1){
                max=increase[i]+decrease[i]-1;
            }
        }
        System.out.println(max);
    }
}
