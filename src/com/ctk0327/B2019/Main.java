package com.ctk0327.B2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N;
    static PriorityQueue<Integer>[] feeList;
    static long answer = 0;
    static ArrayList<Integer> ar;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        feeList = new PriorityQueue[10001];
        ar = new ArrayList<>();
        ar.add(0);
        feeList[0] = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int fee = sc.nextInt();
            int due = sc.nextInt();
            if (feeList[due] == null) {
                feeList[due] = new PriorityQueue<>(Comparator.reverseOrder());
            }
            feeList[due].offer(fee);
            if (!ar.contains(due)) {
                ar.add(due);

            }
        }
        ar.sort(Comparator.reverseOrder());

        for (int i = 0; i < ar.size() - 1; i++) {
            int nowD = ar.get(i);
            int nextD = ar.get(i + 1);
            int diff = nowD - nextD;
            while (diff > 0) {
                if (feeList[nowD].peek() != null) {
                    answer += feeList[nowD].poll();
                }
                diff--;
            }
            feeList[ar.get(i + 1)].addAll(feeList[nowD]);
        }
        System.out.println(answer);
    }
}
