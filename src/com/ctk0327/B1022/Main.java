package com.ctk0327.B1022;

import java.util.Scanner;

public class Main {
    static int x1, y1, x2, y2, numX, numY;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();
        sb = new StringBuilder();
        numX = x2 - x1 + 1;
        numY = y2 - y1 + 1;
        int len = 0;
        for (int i = x1; i < numX + x1; i++) {
            for (int j = y1; j < numY + y1; j++) {
                int tempLen = String.valueOf(makeNum(i, j)).length();
                if (tempLen > len) {
                    len = tempLen;
                }
            }
        }
        for (int i = x1; i < numX + x1; i++) {
            for (int j = y1; j < numY + y1; j++) {
                String temp = String.valueOf(makeNum(i, j));
                int tempLen = temp.length();
                if (tempLen == len) {
                    sb.append(temp);
                } else {
                    for (int k = 0; k < len-tempLen; k++) {
                        sb.append(" ");
                    }
                    sb.append(temp);
                }
                if (j != numY + y1 - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static int makeNum(int x, int y) {
        int n = Math.max(Math.abs(x), Math.abs(y));
        int result = 0;
        int MaxN = (2 * n + 1) * (2 * n + 1);
        if (x == n) {
            result = MaxN - (n - y);
        } else if (y == -n) {
            result = MaxN - (2 * n) - (n - x);
        } else if (x == -n) {
            result = MaxN - (2 * n) * 2 - (n + y);
        } else if (y == n) {
            result = MaxN - (2 * n) * 3 - (n + x);
        }
        return result;
    }
}
