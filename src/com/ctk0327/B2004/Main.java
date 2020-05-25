package com.ctk0327.B2004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long N=sc.nextInt();
        long M=sc.nextInt();
        long divider=5;
        long divider2=2;
        int count1=0;
        int count11=0;
        int count2=0;
        int count21=0;
        int count3=0;
        int count31=0;
        int result=0;
        if(M==0){
            System.out.println("0");
            return;
        }
        while(N>=divider){
            count1+=N/divider;
            divider=divider*5;
        }

        while(N>=divider2){
            count11+=N/divider2;
            divider2=divider2*2;
        }
        divider=5;
        divider2=2;
        while(M>=divider){
            count2+=M/divider;
            divider=divider*5;
        }
        while(M>=divider2){
            count21+=M/divider2;
            divider2=divider2*2;
        }

        divider=5;
        divider2=2;
        while(N-M>=divider){
            count3+=(N-M)/divider;
            divider=divider*5;
        }
        while(N-M>=divider2){
            count31+=(N-M)/divider2;
            divider2=divider2*2;
        }
        if(count1-count2-count3<count11-count21-count31){
            result=count1-count2-count3;
        }else{
            result=count11-count21-count31;
        }
        System.out.println(result);
    }
}
