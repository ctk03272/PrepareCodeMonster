package com.ctk0327.B1011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long start, end,dist;
        for (int i = 0; i < T; i++) {
            start = sc.nextLong();
            end = sc.nextLong();
            dist=end-start;
            long temp= (long) Math.sqrt(dist);
            if(temp==Math.sqrt(dist)){
                System.out.println(temp*2-1);
            }else{
                if(dist>temp*temp+temp){
                    System.out.println(temp*2+1);
                }else{
                    System.out.println(temp*2);
                }
            }
        }
    }
// 시간 초과가 나는 코드
 /*   private static int getNumber(int start, int end) {
        int dist = end - start;
        int count = (int) Math.sqrt(dist);
        while (true) {
            if (getMaxN(count) >= dist) {
                break;
            }
            count++;
        }
            return count;
    }

    private static int getMaxN(int n) {
        int temp;
        if (n % 2 == 0) {
            temp=n/2;
            return temp*temp+temp;
        }else{
            temp=n/2+1;
            return temp*temp;
        }
    }*/
}
