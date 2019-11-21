package com.ctk0327.B4153;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int line1, line2, line3;
        while (true) {
            line1 = sc.nextInt();
            line2 = sc.nextInt();
            line3 = sc.nextInt();
            if (line1 == 0 && line2 == 0 && line3 == 0) {
                break;
            }else{
                if (isGic(line1, line2, line3)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }
        }
    }

    private static boolean isGic(int line1, int line2, int line3) {
        if (line1 * line1 == line2 * line2 + line3 * line3 || line3 * line3 == line2 * line2 + line1 * line1 || line2 * line2 == line1 * line1 + line3 * line3) {
            return true;
        } else {
            return false;
        }
    }
}
