package com.ctk0327.Coupang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine();
        System.out.println(solution(s));
    }
    static int solution(String S){
        int[] count=new int[26];
        int length=S.length();
        int answer=0;
        for (int i = 0; i <length ; i++) {
            count[S.charAt(i)-97]++;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i]%2!=0){
                answer++;
            }
        }
        return  answer;
    }
}
