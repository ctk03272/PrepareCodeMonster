package com.ctk0327.B2562;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nextInt;
        int index=0;
        int maxValue=Integer.MIN_VALUE;
        for (int i = 1; i <=9 ; i++) {
            nextInt=sc.nextInt();
            if(nextInt>maxValue){
                maxValue=nextInt;
                index=i;
            }
        }
        ArrayList ar=new ArrayList();


        System.out.println(maxValue);
        System.out.println(index);


    }
}
