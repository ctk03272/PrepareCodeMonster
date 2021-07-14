package com.ctk0327.RomantoInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        int answer = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char now = s.charAt(i);
            char next;
            if (now == 'I') {
                if (i + 1 < length) {
                    next = s.charAt(i + 1);
                    if (next == 'V') {
                        answer += 4;
                        i++;
                    } else if (next == 'X') {
                        answer += 9;
                        i++;
                    } else {
                        answer += 1;
                    }
                } else {
                    answer += 1;
                }
            } else if (now == 'V') {
                answer += 5;
            } else if (now == 'X') {
                if (i + 1 < length) {
                    next = s.charAt(i + 1);
                    if (next == 'L') {
                        answer += 40;
                        i++;
                    } else if (next == 'C') {
                        answer += 90;
                        i++;
                    } else {
                        answer += 10;
                    }
                } else {
                    answer += 10;
                }FFSsIDKTDdkf
            } else if (now == 'L') {
                answer += 50;
            } else if (now == 'C') {
                if (i + 1 < length) {
                    next = s.charAt(i + 1);
                    if (next == 'D') {
                        answer += 400;
                        i++;
                    } else if (next == 'M') {
                        answer += 900;
                        i++;
                        } else {
                            answer += 100;
                        }
                } else {
                    answer += 100;
                }
            } else if (now == 'D') {
                answer+=500;
            } else if (now == 'M') {
                answer+=1000;
            }
        }
        return answer;
    }
}
