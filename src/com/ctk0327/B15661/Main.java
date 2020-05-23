package com.ctk0327.B15661;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] input;
    static boolean[] team;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input=new int[N][N];
        team=new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        answer = Integer.MAX_VALUE;
        team = new boolean[N];
        dfs(0);
        System.out.println(answer);

    }

    public static void dfs(int M) {
        if (M == N) {
            int sum = getSum();
            if (sum < answer) {
                answer = sum;
            }
            return;
        }
        team[M]=true;
        dfs(M+1);
        team[M]=false;
        dfs(M+1);
    }

    public static int getSum() {
        int startSum = 0;
        int linkSum = 0;
        int startCount=0;
        for (int i = 0; i <N ; i++) {
            if(team[i]) startCount++;
        }
        if(startCount!=N/2){
            return Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (team[i] == team[j]) {
                    if (team[i]) {
                        startSum += input[i][j] + input[j][i];
                    } else {
                        linkSum += input[i][j] + input[j][i];
                    }
                } else {
                    continue;
                }
            }
        }
        return Math.abs(startSum - linkSum);
    }
}
