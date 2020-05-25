package com.ctk0327.B5086;

import java.util.Scanner;

public class Main {
    static int first,second;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            first=sc.nextInt();
            second=sc.nextInt();
            if(first==0 && second==0){
                break;
            }
            if(first % second ==0){
                System.out.println("multiple");
            }else if(second % first ==0){
                System.out.println("factor");
            }else{
                System.out.println("neither");
            }
        }
    }
}
