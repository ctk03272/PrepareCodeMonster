package com.ctk0327.B10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static ArrayList<Integer> input;
    static boolean[][] isPel;
    static int first, last;


    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        N = sc.nextInt();
        input = new ArrayList<>();
        input.add(0);
        for (int i = 0; i <N ; i++) {
            input.add(sc.nextInt());
        }
        isPel = new boolean[N + 1][N + 1];
        for (int j = 0; j < N; j++) {
            for (int i = 1; i + j <= N; i++) {
                if (j == 0) {
                    isPel[i][i + j] = true;
                } else if (j == 1 && input.get(i) == input.get(i + j)) {
                    isPel[i][i + j] = true;
                } else {
                    if (isPel[i + 1][i + j - 1] && input.get(i) == input.get(i + j)) {
                        isPel[i][i + j] = true;
                    }
                }
            }
        }
        M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            first = sc.nextInt();
            last = sc.nextInt();
            if(first>last){
                int tempInt=first;
                first=last;
                last=tempInt;
            }
            if (isPel[first][last]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}