package com.ctk0327.ArrayManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long input[] = new long[n + 2];
        long m = queries.length;
        int start,end,value;
        for (int i = 0; i < m; i++) {
            start=queries[i][0];
            end=queries[i][1];
            value=queries[i][2];
            input[start]+=value;
            input[end+1]-=value;
        }
        long result=0;
        long after=0;
        for (int i = 1; i <=n ; i++) {
            after=after+input[i];
            if(after>result){
                result=after;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }
        long result = arrayManipulation(n, queries);
        System.out.println(result);
        scanner.close();
    }
}
