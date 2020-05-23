package com.ctk0327.P12909;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution("(())"));
    }

    private static boolean Solution(String s) {
        boolean answer= true;
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    answer=false;
                }
            }
        }
        if(!st.isEmpty()){
            answer=false;
        }
        return answer;
    }
}
