package com.ctk0327.B11722;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] in = new int[N];
        int[] min = new int[N];
        for (int i = 0; i < N; i++) {
            in[i] = sc.nextInt();
            min[i]=1;
        }
        int result=1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (in[j] > in[i] && min[i] < min[j] +1) {
                    min[i] = min[j] + 1; // 순회하면서 값이 더 작아지는 경우에만 길이 늘어남
                    if(result<min[i]){
                        result=min[i];//더 큰 값일 경우 리턴값 갱신
                    }
                }
            }
        }
        System.out.println(result);
    }
}
