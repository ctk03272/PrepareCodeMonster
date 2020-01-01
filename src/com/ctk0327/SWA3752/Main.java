package com.ctk0327.SWA3752;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int[] score;
    static int T;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T > 0) {
            N = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for (int i = 0; i < N; i++) {
                int add = sc.nextInt();
                Set<Integer> temp=new HashSet<>();
                temp.addAll(set);
                temp.stream().forEach(a->set.add(a+add));
            }
            System.out.println("#"+T+" "+set.size());
            T--;
        }
    }
}
