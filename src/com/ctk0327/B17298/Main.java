package com.ctk0327.B17298;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static Stack<Integer> st;
    static int[] input;
    static int[] rightBigger;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        rightBigger = new int[N];
        Arrays.fill(rightBigger,-1);
        sb=new StringBuilder();
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        st = new Stack();

        for (int i = 0; i < N; i++) {

            while (!st.isEmpty()) {
                if (input[st.peek()] < input[i]) {
                    rightBigger[st.pop()] = input[i];
                } else {
                    st.push(i);
                    break;
                }
            }
            if (st.isEmpty()) {
                st.push(i);
            }
        }
        for (int i = 0; i <N; i++) {
            sb.append(rightBigger[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
