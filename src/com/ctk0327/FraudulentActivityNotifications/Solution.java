package com.ctk0327.FraudulentActivityNotifications;

import static java.lang.System.in;

import java.io.*;
import java.util.*;

public class Solution {
    static int MAX = 200001;
    static int[] tree;

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notification = 0;
        int treeSize = MAX * 3;
        int size = expenditure.length;
        tree = new int[treeSize];
        int m = (d + 1) / 2;
        double median = 0;
        for (int i = 0; i < d; i++) {
            updateTree(1, expenditure[i], 0, MAX, true);
        }
        if (d % 2 == 0) {
            median = ((double) getMedian(1, m, 0, MAX) + getMedian(1, m + 1, 0, MAX)) / 2;
        } else {
            median=getMedian(1, m, 0, MAX);
        }
        if(expenditure[d]>=median*2){
            notification++;
        }
//        int median = getMedian(1,m,0,MAX);
        for (int i = d; i < size-1; i++) {
            updateTree(1, expenditure[i - d], 0, MAX, false);
            updateTree(1, expenditure[i], 0, MAX, true);
            if (d % 2 == 0) {
                median = ((double)getMedian(1, m, 0, MAX) + getMedian(1, m + 1, 0, MAX)) / 2;
            } else {
                median=getMedian(1, m, 0, MAX);
            }
            if(expenditure[i+1]>=median*2){
                notification++;
            }
        }
        System.out.println(notification);
        return notification;
    }

    private static void updateTree(int index, int num, int l, int r, boolean isADD) {
        if (num >= l && num <= r) {
            if (isADD) {
                tree[index] += 1;
            } else {
                tree[index] -= 1;
            }
        } else {
            return;
        }
        if (l != r) {
            updateTree(2 * (index), num, l, (l + r) / 2, isADD);
            updateTree(2 * (index) + 1, num, (l + r) / 2 + 1, r, isADD);
        }
    }

    private static int getMedian(int index, int d, int start, int end) {
        int mid = (start + end) / 2;

        if (start == end) {
            return start;
        }

        if (tree[index * 2] < d) {
            return getMedian(index * 2 + 1, d - tree[index * 2], mid + 1, end);
        } else {
            return getMedian(index * 2, d, start, mid);
        }
    }

    private static final Scanner scanner = new Scanner(in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];
        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        scanner.close();
    }
}
