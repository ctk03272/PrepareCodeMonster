package com.ctk0327.B6598;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static String[] input;
    static int pc;
    static int add;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            input = new String[33];
            pc = 0;
            add = 0;
            for (int i = 0; i < 32; i++) {
                input[i] = sc.nextLine();
            }
            while (!solve(input[pc])) {
            }
        }
    }

    private static boolean solve(String s) {
        boolean isEnd = false;
        String first = s.substring(0, 3);
        String last = s.substring(3, 8);
        if (pc == 31) {
            pc = 0;
        } else {
            pc++;

        }
        switch (first) {
            case "000":
                input[memToInt(last)] = intToMem(add, false);
                break;
            case "001":
                add = memToInt(input[memToInt(last)]);
                break;
            case "010":
                if (add == 0) {
                    pc = memToInt(last);
                }
                break;
            case "011":
                break;
            case "100":
                if (add == 0) {
                    add = 255;
                } else {
                    add--;
                }
                break;
            case "101":
                if (add == 255) {
                    add = 0;
                } else {
                    add++;
                }
                break;
            case "110":
                pc = memToInt(last);
                break;
            case "111":
                System.out.println(intToMem(add, true));
                isEnd = true;
                break;
        }
        return isEnd;
    }

    private static int memToInt(String last) {
        int result = 0;
        int length = last.length();
        int index = 1;
        for (int i = length - 1; i >= 0; i--) {
            result += Integer.parseInt(last.substring(i, i + 1)) * index;
            index = index * 2;
        }
        return result;
    }

    private static String intToMem(int add, boolean isEnd) {
        StringBuilder sb = new StringBuilder();
        int[] temp = new int[512];
        int i = 0;
        if (add == 0) {
            return "00000000";
        }
        while (add != 1) {
            temp[i++] = add % 2;
            add = add / 2;
        }
        temp[i] = add;
        for (int j = i; j >= 0; --j) {
            sb.append(temp[j]);
        }
        return sb.toString();
    }
}
