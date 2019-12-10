package com.ctk0327.B17845;

import java.util.Scanner;

public class Main {
    // 1차원 배열 사용시
    static int N, K;
    static Cl[] input;
    static int[]important;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        input = new Cl[K + 1];
        important = new int[N + 1];
        for (int i = 1; i <= K; i++) {
            input[i] = new Cl(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i <= N; i++) {

        }
        for (int i = 1; i <=K; i++) {
            for (int j = N; j-input[i].time>=0; j--) {
                important[j]=Math.max(important[j],important[j-input[i].time]+input[i].important);
            }
        }

        for (int i = 0; i <= N; i++) {
            if(max<important[i]){
                max=important[i];
            }
        }
        System.out.println(max);
    }

    // 2차원 배열 사용시
    /*    static int N, K;
    static Cl[] input;
    static int[][] important;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        input = new Cl[K + 1];
        important = new int[N + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            input[i] = new Cl(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (input[j].time > i) {
                    important[i][j] = important[i][j - 1];
                } else {
                    important[i][j] = Math.max(important[i - input[j].time][j - 1] + input[j].important,
                                               important[i][j - 1]);
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (max < important[i][j]) {
                    max = important[i][j];
                }
            }
        }
        System.out.println(max);
    }*/
}

class Cl {
    int important;
    int time;

    public Cl(int important, int time) {
        this.important = important;
        this.time = time;
    }
}
