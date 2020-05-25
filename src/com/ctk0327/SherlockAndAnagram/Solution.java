package com.ctk0327.SherlockAndAnagram;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        solve(input);
    }

    private static void solve(String input) {
        int result=0;
        ArrayList<String> ar = new ArrayList<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                ar.add(input.substring(i, j + 1));
            }
        }

        int length2 = ar.size();
        for (int i = 0; i < length2; i++) {
            String input1 = ar.get(i);
            for (int j = i+1; j < length2; j++) {
                String input2 = ar.get(j);
                if(isAna(input1, input2)){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isAna(String input1, String input2) {
        int[] check=new int[26];
        boolean isAna=true;
        for (int i = 0; i < input1.length(); i++) {
            check[input1.charAt(i)-97]++;
        }
        for (int i = 0; i < input2.length(); i++) {
            check[input2.charAt(i)-97]--;
        }

        for (int i = 0; i < check.length; i++) {
            if(check[i]!=0){
                isAna=false;
                break;
            }
        }
        return isAna;
    }
}
