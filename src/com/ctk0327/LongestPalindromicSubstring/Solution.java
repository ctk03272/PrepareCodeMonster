package com.ctk0327.LongestPalindromicSubstring;

public class Solution {
    static int answer=1;
    public static void main(String[] args) {
        Solution solution=new Solution();
        String input="aaba";
        for (int i = 0; i <input.length() ; i++) {
            solution.longestPalindrome(input,i,i);
        }
        for (int i = 0; i <input.length()-1 ; i++) {
            if(input.charAt(i)==input.charAt(i+1)){
                answer=Math.max(answer,2);
                solution.longestPalindrome(input,i,i+1);
            }
        }
        System.out.println(answer);
    }
    public void longestPalindrome(String s,int i,int j) {
        if(i>0 && j<s.length()-1 && s.charAt(i-1)==s.charAt(j+1)){
            answer=Math.max(j+1-(i-1)+1,answer);
            longestPalindrome(s,i-1,j+1);
        }
    }
}
