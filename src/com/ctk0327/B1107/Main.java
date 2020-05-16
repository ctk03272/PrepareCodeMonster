package com.ctk0327.B1107;

import java.util.Scanner;

public class
Main {
    static boolean[] broken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        broken = new boolean[10];
        boolean allBroken = true;
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }
        for (int i = 0; i < 10; i++) {
            if (!broken[i]) {
                allBroken = false;
            }
        }
        int result = 0;
        int count = 0;
        int lengthCount=0;
        while (!allBroken) {
            int upper = N + count;
            int down = N - count;
            if (isAvailable(down)) {
                lengthCount=String.valueOf(down).length();
                break;
            }

            if (isAvailable(upper)) {
                lengthCount=String.valueOf(upper).length();
                break;
            }
            count++;
        }
        count = Math.min(count + lengthCount, Math.abs(N - 100));
        if (allBroken) {
            count = Math.abs(N - 100);
        }
        System.out.println(count);
    }

    private static boolean isAvailable(int input) {
        if(input<0){
            return false;
        }
        boolean isAvailable = true;
        do {
            if (broken[input % 10]) {
                isAvailable = false;
            }
            input = input / 10;
        } while (input != 0);
        return isAvailable;
    }
}
