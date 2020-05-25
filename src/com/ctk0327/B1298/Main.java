package com.ctk0327.B1298;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] match;
    static boolean[] visited;
    static ArrayList<Integer>[] ar;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        ar=new ArrayList[101];
        match=new int[5005];
        visited=new boolean[101];
        for (int i = 1; i <=N ; i++) {
            ar[i]=new ArrayList();
        }
        for (int i = 0; i < M; i++) {
          int student=sc.nextInt();
          int laptop=sc.nextInt();
          ar[student].add(laptop);
        };
        int result=0;
        for (int i = 1; i <= N; i++) {
            visited=new boolean[101];
            if(dfs(i)){
                result++;
            }
        }
        System.out.println(result);
    }
    static boolean dfs(int now){
        if(visited[now]){
            return false;
        }
        visited[now]=true;
        for(int next:ar[now]){
            if(match[next]==0 || dfs(match[next])){
                match[next]=now;
                return true;
            }
        }
        return false;
    }
}

