package com.ctk0327.B2447;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String baseStar="***\n* *\n***";
        System.out.println(makeStar(getNumber(N)));
    }

    private static int getNumber(int n) {
        int count=0;
        while(n!=1){
            n=n/3;
            count++;
        }
        return count;
    }

    private static String makeStar(int n) {
        String baseStar="***\n* *\n***";
        if(n==1){
            return baseStar;
        }else{
            StringBuilder sb=new StringBuilder();
            sb.append(makeStar(n-1));
            sb.append(makeStar(n-1));
            sb.append(makeStar(n-1));
            sb.append("\n");
            sb.append(makeStar(n-1));
            sb.append(makeNull(n-1));
            sb.append(makeStar(n-1));
            sb.append("\n");
            sb.append(makeStar(n-1));
            sb.append(makeStar(n-1));
            sb.append(makeStar(n-1));
            return sb.toString();
        }
    }

    private static String makeNull(int i) {
        StringBuilder sb=new StringBuilder();
        int n=i*3;
        for (int j = 0; j <n ; j++) {
            for (int k = 0; k <n; k++) {
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
