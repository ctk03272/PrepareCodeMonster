package com.ctk0327.B14391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] input;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tempIn[]=bf.readLine().split(" ");
        N = Integer.valueOf(tempIn[0]);
        M = Integer.valueOf(tempIn[1]);
        String[] temp;
        input=new int[N][M];
        visited=new boolean[N][M];
        for (int i = 0; i < N; i++) {
            temp = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                input[i][j]=Integer.valueOf(temp[j]);
            }
        }
        dfs(0,0);
        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        if(x==N){
            result=Math.max(result,getSum());
            return;
        }
        if(y==M){
            dfs(x+1,0);
            return;
        }

        visited[x][y]=true;
        dfs(x,y+1);
        visited[x][y]=false;
        dfs(x,y+1);
    }

    static int getSum() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    sum = (sum * 10) + input[i][j];
                } else {
                    answer += sum;
                    sum = 0;
                }
            }
            answer += sum;
        }

        for (int j = 0; j < M; j++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i][j]) {
                    sum = (sum * 10) + input[i][j];
                } else {
                    answer += sum;
                    sum = 0;
                }
            }
            answer += sum;
        }
        return answer;
    }
}
