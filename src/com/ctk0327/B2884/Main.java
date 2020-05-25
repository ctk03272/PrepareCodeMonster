package com.ctk0327.B2884;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        int hourResult;
        int minuteResult;
        if (minute >= 45) {
            minuteResult = minute - 45;
            hourResult = hour;
        } else {
            minuteResult = minute+15;
            if (hour == 0) {
                hourResult = 23;
            } else {
                hourResult = hour - 1;
            }
        }
        System.out.printf("%d %d",hourResult,minuteResult);
    }
}
