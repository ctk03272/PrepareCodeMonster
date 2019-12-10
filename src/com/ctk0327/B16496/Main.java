package com.ctk0327.B16496;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static boolean isZero = true;
    static String[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        input = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        Arrays.stream(input).sorted((a, b) -> {
            if ((!a.equals("0")) || !b.equals("0")) {
                isZero = false;
            }
            int n = Math.min(a.length(), b.length());
            int m = Math.max(a.length(), b.length());
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return b.charAt(i) - a.charAt(i);
                }
            }
            for (int i = n; i < m; i++) {
                int first = a.length() > i ? a.charAt(i) : b.charAt(i-a.length());
                int last = b.length() > i ? b.charAt(i) : a.charAt(i-b.length());
                if(first==last){
                    continue;
                }
                return last - first;
            }
            return 0;
        }).forEach(sb::append);
        if (isZero) {
            System.out.println("0");
        } else {

            System.out.println(sb.toString());
        }
    }
}
