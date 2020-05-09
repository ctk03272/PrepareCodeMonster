package com.ctk0327.B14002;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] in = new int[N];
        int[] last=new int[N];
        for (int i = 0; i <N ; i++) {
            last[i]=-1;
        }
        for (int i = 0; i < N; i++) {
            in[i] = sc.nextInt();
        }
        int[] max = new int[N];
        for (int i = 0; i < N; i++) {
            max[i] = 1;
            for (int j = 0; j < i; j++) {
                if (in[j] < in[i] && max[i] < max[j] + 1) {
                    max[i] = max[j] + 1;
                    last[i]=j;
                }
            }
        }
        int index=0;
        int tempMax=Integer.MIN_VALUE;
        for (int i = 0; i <N ; i++) {
            if(tempMax<max[i]){
                tempMax=max[i];
                index=i;
            }
        }
        System.out.println(tempMax);
        Stack<Integer> ar=new Stack<>();
        while(index!=-1){
            ar.add(in[index]);
            index=last[index];
        }
        while (!ar.isEmpty()){
            System.out.print(ar.pop());
            System.out.print(" ");
        }
//        Arrays.sort(max);
//        System.out.println(max[N - 1]);
    }
}
