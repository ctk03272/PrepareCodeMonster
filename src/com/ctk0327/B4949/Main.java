package com.ctk0327.B4949;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static String input;
    static Stack<Character> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            input = sc.nextLine();
            if (input.equals(".")) {
                break;
            } else {
                stack = new Stack<>();
                if (isValid()) {
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }
        }
    }

    private static boolean isValid() {
        boolean result=true;
        int lenght=input.length();
            for (int i = 0; i < lenght; i++) {
                char temp=input.charAt(i);
                if(temp=='('){
                    stack.push(temp);
                }else if(temp==')'){
                    if(stack.isEmpty() || stack.pop()!='('){
                        result=false;
                    }
                }else if(temp=='['){
                    stack.push(temp);
                }else if(temp==']' ){
                    if(stack.isEmpty() || stack.pop()!='['){
                        result=false;
                    }
                }
            }
            if(!stack.isEmpty()){
                result=false;
            }
            return result;
    }
}
