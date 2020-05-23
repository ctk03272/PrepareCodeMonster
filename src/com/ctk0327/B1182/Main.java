package com.ctk0327.B1182;

import java.util.Scanner;

public class Main {
    static int N,S;
    static int[] input;
    static int answer;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        S=sc.nextInt();
        input=new int[N];
        for (int i = 0; i < N; i++) {
            input[i]=sc.nextInt();
        }
        answer=0;
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int index, int sum) {
        if(index==N){
            return;
        }
        if(sum+input[index]==S){
            answer++;
        }
        dfs(index+1,sum+input[index]);

        dfs(index+1,sum);
    }
}
