package com.ctk0327.B1322;

import java.util.Scanner;

public class Main {
    static String input;
    static int X, K;
    static String output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        K = sc.nextInt();
        input = Integer.toBinaryString(X);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        String maxY = sb.toString();
        String convertK = Integer.toBinaryString(K);
        StringBuilder sb2 = new StringBuilder();
        int index=0;
        for (int i = 0; i < 100; i++) {
            if (i >=maxY.length() ||maxY.charAt(maxY.length()-i-1) == '1') {
                if(index <convertK.length() && convertK.charAt(convertK.length()-index-1)=='1' ){
                    sb2.append('1');
                }else{
                    sb2.append('0');
                }
                index++;
            } else {
                sb2.append('0');
            }
        }

        String temp = Integer.toBinaryString(K);
        System.out.println(Long.parseLong(sb2.reverse().toString(),2));
    }
}
