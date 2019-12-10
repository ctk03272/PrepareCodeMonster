package com.ctk0327.B1614;

import java.util.Scanner;

public class Main {
    static long M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextLong();
        N = sc.nextLong();
        long temp = M - 1;
        long temp2 = N % 2;
        long temp3=N/2;
        long answer = 0;
        if (N != 0) {
            if (M % 4 == 1) {
                answer = temp + 8 * N;
            } else {
                answer = temp + temp3* 8 +temp2*(8-(M-1)*2);
            }
        }else{
            answer=temp;
        }
        System.out.print(answer);
    }
}
