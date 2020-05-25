package com.ctk0327.B9375;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int T, N;
    static HashMap<String, ArrayList<String>> input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T > 0) {
            int result=1;
            N = sc.nextInt();
            sc.nextLine();
            input = new HashMap();
            for (int i = 0; i < N; i++) {
                String temp = sc.nextLine();
                String cl[] = temp.split(" ");
                if (!input.containsKey(cl[1])) {
                    ArrayList ar = new ArrayList();
                    ar.add(cl[0]);
                    input.put(cl[1], ar);
                } else {
                    input.get(cl[1]).add(cl[0]);
                }
            }
            for (String key : input.keySet()) {
                result*=(input.get(key).size()+1);
            }
            System.out.println(result-1);
            T--;
        }

    }
}

