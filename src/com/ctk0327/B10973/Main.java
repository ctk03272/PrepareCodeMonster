package com.ctk0327.B10973;

import java.util.Scanner;

public class Main {
    static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i] >= a[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[i - 1] <= a[j]) {
            j--;
        }
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        int k = a.length - 1;
        while (i < k) {
            temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            i++;
            k--;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        if (nextPermutation(a)) {
            for (int i = 0; i < N; i++) {
                System.out.print(a[i]+" ");
            }
        } else {
            System.out.println(-1);
        }
    }
}