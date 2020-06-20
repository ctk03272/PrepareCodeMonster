package com.ctk0327.B3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R, C;
    static char[][] input;
    static int[][] water;
    static int[] dx = {1, -1, 0, 0,};
    static int[] dy = {0, 0, 1, -1};
    static int result=-1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        input = new char[R][C];
        water = new int[R][C];
        sc.nextLine();

        Queue<Dot> waterQue = new LinkedList<>();
        Queue<Dot> kaktusQue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < C; j++) {
                char tempChar = temp.charAt(j);
                input[i][j] = tempChar;
                //input에서 물이 들어오는 곳들은 따로 표시해준다.
                if (tempChar == '*') {
                    waterQue.add(new Dot(i, j, 1));
                    water[i][j] = 1;
                } else if (tempChar == 'S') {
                    kaktusQue.add(new Dot(i, j, 1));
                }

            }
        }

        // 시간에 따른 물의 진행을 계산한다.
        while (!waterQue.isEmpty()) {
            Dot now = waterQue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowTime = now.time;
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (0 <= nx && nx < R && 0 <= ny && ny < C && input[nx][ny] == '.' && water[nx][ny] == 0) {
                    waterQue.add(new Dot(nx, ny, nowTime + 1));
                    water[nx][ny] = nowTime + 1;
                }
            }
        }

        // 고슴도치의 이동을 계산한다.
        while (!kaktusQue.isEmpty()) {
            Dot now = kaktusQue.poll();
            int nowX = now.x;
            int nowY = now.y;
            int nowTime = now.time;
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (0 <= nx && nx < R && 0 <= ny && ny < C && (input[nx][ny] == '.' || input[nx][ny] == 'D') && (water[nx][ny] == 0 || nowTime+1<water[nx][ny] )) {
                    kaktusQue.add(new Dot(nx, ny, nowTime + 1));
                    water[nx][ny] = nowTime + 1;
                    if(input[nx][ny] == 'D'){
                        result=nowTime;
                    }
                }
            }
        }
        System.out.println(result==-1?"KAKTUS":result);
    }
}

class Dot {
    int x;
    int y;
    int time;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Dot(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
