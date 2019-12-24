package com.ctk0327.H11;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int length=q.length;
        int result=0;
        int[] changePostion=new int[length];
        for (int i = 0; i < length; i++) {
            int nowCount=0;
            changePostion[i]=i+1-q[i];
            if( changePostion[i]<-2){
                System.out.println("Too chaotic");
                return;
            }
            for (int j = i; j <j-changePostion[i] ; j++) {
                if(q[j-changePostion[i]]>0){
                    nowCount++;
                }
            }
            for (int j = i; j <nowCount+i ; j++) {
            }
        }
        System.out.println(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}