package com.ctk0327.B2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String[][] input;
    static int[][] dp;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bf.readLine().split(" ");

        int N = Integer.valueOf(temp[0]);
        int M = Integer.valueOf(temp[1]);
        input = new String[N][M];
        dp = new int[N][M];
        visited=new boolean[N][M][2];
        for (int i = 0; i <N ; i++) {
            input[i]=bf.readLine().split("");
            Arrays.fill(dp[i],987654321);
        }

//      초기화를 한다.
        Dots dots = new Dots(0, 0, false);
        dp[0][0] = 1;
        visited[0][0][0]=true;
        Queue<Dots> queue = new LinkedList<>();
        queue.add(dots);

        while (!queue.isEmpty()) {
            Dots dot = queue.poll();
            int x = dot.x;
            int y = dot.y;
            boolean isBreak = dot.isBreak;
            int isBreakNum=isBreak?1:0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (input[nx][ny].equals("0") && !visited[nx][ny][isBreakNum]) {
                        dp[nx][ny]=dp[x][y]+1;
                        queue.add(new Dots(nx,ny,isBreak));
                        visited[nx][ny][isBreakNum]=true;
                    }
                    if((input[nx][ny].equals("1") && isBreak == false) && !visited[nx][ny][1]){
                        dp[nx][ny]=dp[x][y]+1;
                        queue.add(new Dots(nx,ny,true));
                        visited[nx][ny][1]=true;
                    }
                }
                if(dp[N-1][M-1]!=987654321){
                    break;
                }
            }
        }

        System.out.println(dp[N-1][M-1]==987654321?-1:dp[N-1][M-1]);
    }

    static class Dots {
        int x;
        int y;
        boolean isBreak;

        public Dots(int x, int y, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.isBreak = isBreak;
        }
    }
}
