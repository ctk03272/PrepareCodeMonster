package com.ctk0327.B2568;

import java.util.Scanner;

public class Main {
    static int N;
    static int MAX=Integer.MIN_VALUE;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        input= new int[5000001];
        for (int i = 0; i < N; i++) {
            int temp=sc.nextInt();
            input[temp]=sc.nextInt();
            if(temp>MAX){
                MAX=temp;
            }
        }
        int result=lis(input,MAX);
        System.out.println(N-result);
    }

    static int getIndex(int ar[], int l, int r, int key) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (ar[mid] > key) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    static int lis(int arr[], int n) {
        int[] tails = new int[n];
        int length = 1;

        tails[0] = arr[0];

        for (int i = 1; i <= n; i++) {
            if (arr[i] > tails[length - 1]) {
                tails[length++] = arr[i];
            } else {
                tails[getIndex(tails, 0, length - 1, arr[i])] = arr[i];
            }
        }
        return length;
    }
}
