package com.ctk0327.FraudulentActivityNotifications;

import static java.lang.System.in;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notification = 0;
        int median = getMedian(expenditure, 0, d - 1);
        return notification;
    }

    private static int getMedian(int[] expenditure, int start, int end) {
        int size=end-start+1;
        int median=0;
        int[] medainAr = new int[size];
        for (int i = start; i <= end; i++) {
            medainAr[i-start] = expenditure[i];
        }
        Arrays.sort(medainAr);
        if(size%2==0){

        }else{
            median=medainAr[(end-start)/2+start];
        }
        return median;
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
