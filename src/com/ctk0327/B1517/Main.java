package com.ctk0327.B1517;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] input=new int[N];
        for (int i = 0; i < N; i++) {
            input[i]=sc.nextInt();`
        }
        System.out.println(minimumSwaps(input));
    }
    static int minimumSwaps(int[] arr) {
        int result=0;
        for(int i=0;i<arr.length;i++){
            while(i+1!=arr[i]){
                int temp=arr[i];
                arr[i]=arr[temp-1];
                arr[temp-1]=temp;
                result++;
            }
        }
        return result;

    }
}
