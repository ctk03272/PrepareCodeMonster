package com.ctk0327.Codility;

import java.util.Scanner;

public class Main {
    public int solution(int[] A) {
        int answer=0;
        boolean[] input = new boolean[1000001];
        for (int i = 0; i < A.length; i++) {
            if(A[i]<0){
                continue;
            }
            input[A[i]] = true;
        }
        int length = input.length;
        for (int i = 1; i <= 1000000; i++) {
            if (!input[i]) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int[] A = new int[6];
        for (int i = 0; i < 6; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(main.solution(A));
    }
}
