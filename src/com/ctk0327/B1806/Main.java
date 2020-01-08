package com.ctk0327.B1806;

import java.util.Scanner;

public class Main {
    static int N, S;
    static int result;
    static int start,end;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        input=new int[N];
        start=0;end=0;
        result=Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        int sum=input[0];
        while(end<N ){
            if(sum<S){
                ++end;
                if(end>=N){
                    break;
                }
                sum+=input[end];
            }else{
                if(end-start+1<result){
                    result=end-start+1;
                }
                ++start;
                if(start>=N){
                    break;
                }
                sum-=input[start-1];
            }
        }

        System.out.println(result==Integer.MAX_VALUE? 0:result);
    }
}
