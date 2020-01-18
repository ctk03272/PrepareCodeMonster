package com.ctk0327.B1114;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int L, K, C;
    static ArrayList<Integer> cut;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cut = new ArrayList<>();
        L = sc.nextInt();
        K = sc.nextInt();
        C = sc.nextInt();
        for (int i = 0; i < K; i++) {
            cut.add(sc.nextInt());
        }
        cut.add(L);
        cut.sort(Comparator.naturalOrder());
        int start = 0;
        int end = L;
        int mid=0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (canMake(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(mid);
    }

    private static boolean canMake(int input) {
        int sum = 0;
        int count = 0;
        if (cut.get(0) > input) {
            return false;
        }
        int length = cut.size();
        for (int i = 1; i <= length-1; i++) {
            if (cut.get(i) - cut.get(i - 1) > input) {
                return false;
            }
            if (sum + cut.get(i) - cut.get(i - 1) > input) {
                count++;
                sum = cut.get(i) - cut.get(i - 1);
                if (count > C) {
                    return false;
                }
            }else{
                sum+=cut.get(i)-cut.get(i-1);
            }
        }
        return true;
    }
}
