package com.ctk0327.GreedyFlorist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int length=c.length;
        int result=0;
        int count=0;
        int index=1;
        Arrays.sort(c);
        for (int i = length-1; i >=0 ; i--) {
            result+=c[i]*index;
            count++;
            if(count==k){
                count=0;
                index++;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(minimumCost);
        scanner.close();
    }
}
