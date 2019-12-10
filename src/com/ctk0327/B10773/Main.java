package com.ctk0327.B10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<>();
        int N=sc.nextInt();
        int next;
        int result=0;
        for (int i = 0; i <N ; i++) {
            next=sc.nextInt();
            if(next==0){
                st.pop();
            }else{
                st.push(next);
            }
        }
        while(!st.empty()){
            result+=st.pop();
        }
        System.out.println(result);
    }
}
