package com.ctk0327.FrequencyQuries;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[1000000001];
        ArrayList ar=new ArrayList();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 1) {
                input[b]++;
            } else if (a == 2) {
                if (b != 0) {
                    input[b]--;
                }
            } else if (a == 3) {
                int length = input.length;
                boolean isExist = false;
                for (int j = 0; j < length; j++) {
                    if (input[j] == b) {
                        isExist = true;
                    }
                }
                String answer=isExist?"1":"0";
                System.out.println(answer);
            }
        }
    }
}

