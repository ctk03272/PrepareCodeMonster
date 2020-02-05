package com.ctk0327.CodilityTest;

import com.ctk0327.Codility.Main;

import java.util.Scanner;

public class Solution {
    public String solution(String S) {
        int length=S.length();
        char[] answer=new char[length];
        boolean isPel=true;
        for (int i = 0; i < length; i++) {
            if(S.charAt(i)!='?' && S.charAt(length-i-1)!='?' && S.charAt(i)!=S.charAt(length-i-1)){
                isPel=false;
            }else {
                if(S.charAt(i)=='?' && S.charAt(length-i-1)!='?'){
                    answer[i]=S.charAt(length-i-1);
                    answer[length-i-1]=S.charAt(length-i-1);
                }else if (S.charAt(i)!='?' && S.charAt(length-i-1)=='?'){
                    answer[i]=S.charAt(i);
                    answer[length-i-1]=S.charAt(i);
                }else if(S.charAt(i)=='?' && S.charAt(length-i-1)=='?'){
                    answer[i]='a';
                    answer[length-i-1]='a';
                }else{
                    answer[i]=S.charAt(i);
                    answer[length-i-1]=S.charAt(length-i-1);
                }
            }
        }
        // write your code in Java SE 8
        return isPel? new String(answer):"NO";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        System.out.println(solution.solution(temp));
    }
}
