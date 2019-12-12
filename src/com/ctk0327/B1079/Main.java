package com.ctk0327.B1079;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int playerNumber;
    static boolean[] isDead;
    static int result = 0;
    static int[] score;
    static int[][] R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        isDead = new boolean[N];
        score = new int[N];
        R = new int[N][N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = sc.nextInt();
            }
        }
        playerNumber = sc.nextInt();
        int count = 0;
        doGame(count, score);
        System.out.println(result);
    }

    private static void doGame(int count, int[] nowScore) {
        int deadCont = 0;
        for (int i = 0; i < N; i++) {
            if (isDead[i]) {
                deadCont++;
            }
        }
        if ((N - deadCont) % 2 == 0) {
            doNight(count, nowScore);
        } else {
            doDayTime(count, nowScore);
        }
    }

    private static void doNight(int count, int[] nowScore) {
        for (int i = 0; i < N; i++) {
            int[] tempScore = Arrays.copyOf(nowScore, nowScore.length);
            if (!isDead[i] && i != playerNumber) {
                isDead[i] = true;
            } else {
                continue;
            }
            for (int j = 0; j < N; j++) {
                tempScore[j] += R[i][j];
            }
            int liveCount=0;
            for (int j = 0; j <N ; j++) {
                if(isDead[j]=false){
                    liveCount++;
                }
            }
            if(liveCount==1){
                if(count>result){
                    result=count;
                }
                doGame(count, tempScore);
            }
            doGame(count + 1, tempScore);
            isDead[i] = false;
        }
    }

    private static void doDayTime(int count, int[] nowScore) {
        int findPlayer = -1;
        int high = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            if (!isDead[i] & high <= nowScore[i]) {
                findPlayer = i;
                high = nowScore[i];
            }
        }
        if (findPlayer == playerNumber) {
            if (count > result) {
                result = count;
            }
        } else {
            isDead[findPlayer] = true;
            doGame(count, nowScore);
        }
    }
}
