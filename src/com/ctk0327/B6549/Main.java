package com.ctk0327.B6549;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String lineInput;
    static String[] parseLineInput;
    static int N;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            lineInput = sc.nextLine();
            parseLineInput = lineInput.split(" ");
            N = Integer.parseInt(parseLineInput[0]);
            input = new int[N];
/*            dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i],-1);
            }*/
            if (N == 0) {
                break;
            }
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(parseLineInput[i + 1]);
            }
            System.out.println(printMax(0, N - 1));
        }
    }

    private static int printMax(int start, int end) {
        if (start == end) {
            return input[start];
        } else if(start>end){
            return 0;
        }else {
            int result = 0;
            int count = 0;
            int middle = (start + end) / 2;
            int leftI = middle - 1;
            int rightI = middle;
            int left = printMax(start, middle);
            int right = printMax(middle + 1, end);
            int h = Math.min(input[leftI], input[rightI]);
            while (leftI >= left && rightI < right) {
                if (input[leftI] < input[right]) {
                    h = Math.min(h, input[leftI]);
                    leftI--;
                } else {
                    h = Math.min(h, input[rightI]);
                    rightI--;
                }
                count++;
                result = Math.max(result, count * 2);
            }
            while (leftI >= left) {
                h = Math.min(h, input[leftI]);
                leftI--;
                count++;
                result = Math.max(result, count * 2);
            }
            while (rightI < right) {
                h = Math.min(h, input[rightI]);
                rightI--;
                count++;
                result = Math.max(result, count * 2);
            }
            return result;
        }
    }
}
