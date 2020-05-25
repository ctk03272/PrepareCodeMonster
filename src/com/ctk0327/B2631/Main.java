package com.ctk0327.B2631;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] input=new int[N];
        for (int i = 0; i < N; i++) {
            input[i]=sc.nextInt();
        }
        System.out.println(N-lis(input, N));
    }
    static int lis(int[] arr,int n) {
        int[] tails = new int[n];
        int length = 1;

        tails[0] = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] > tails[length - 1]) {
                tails[length++] = arr[i];
            } else {
                tails[getIndex(tails, 0, length - 1, arr[i])] = arr[i];
            }
        }
        return length;
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
}
