package com.ctk0327.B11055;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] in = new int[N];
        int[] max = new int[N];
        for (int i = 0; i < N; i++) {
            in[i] = sc.nextInt();
            max[i]=in[i];// 초기 최대값 자기 자신
        }
        int result=in[0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (in[j] < in[i] && max[i] < max[j] +in[i]) {
                    max[i] = max[j] + in[i]; // 순회하면서 맥스값이 더 커지는 경우에 맥스값 갱신
                    if(result<max[i]){
                        result=max[i];
                    }
                }
            }
        }
        System.out.println(result);
    }
}