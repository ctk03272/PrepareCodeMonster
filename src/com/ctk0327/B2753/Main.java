package com.ctk0327.B2753;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        int yoon=0;
        boolean temp1=input%4==0?true:false;
        boolean temp2=input%100==0?true:false;
        boolean temp3=input%400==0?true:false;
        if(temp1&& (!temp2||temp3)){
            yoon=1;
        }
        System.out.printf(String.valueOf(yoon));
    }
}
