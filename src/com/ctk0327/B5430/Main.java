package com.ctk0327.B5430;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int T, N;
    static String[] fn;
    static Deque<Integer> input;
    static Deque<Integer> output;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            fn = sc.nextLine().split("");
            N = Integer.valueOf(sc.nextLine());
            String line = sc.nextLine();
            input = new LinkedList<>();
            output = new LinkedList<>();
            sb = new StringBuilder();
            if (N != 0) {
                Arrays.stream(line.split(",")).map(a -> {
                                                       String temp = a;
                                                       if (temp.contains("[")) {
                                                           temp = temp.substring(1);
                                                       }
                                                       if (temp.contains("]")) {
                                                           temp = temp.substring(0, temp.length() - 1);
                                                       }
                                                       return temp;
                                                   }
                ).mapToInt(Integer::valueOf).forEach(a -> input.offer(a));
            }
            try {
                boolean isReverse = false;
                isReverse = takeFunction(fn);
                if (isReverse) {
                    while (!input.isEmpty()) {
                        output.offer(input.removeLast());
                    }
                } else {
                    output = input;
                }
                sb.append("[");
                while (!output.isEmpty()) {
                    sb.append(output.removeFirst());
                    if (!output.isEmpty()) {
                        sb.append(",");
                    }else{
                        break;
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            } catch (Exception e) {
                System.out.println("error");
            }

        }
    }

    private static boolean takeFunction(String[] fn) throws Exception {
        boolean isReverse = false;
        int length = fn.length;
        String temp = "";
        for (int i = 0; i < length; i++) {
            temp = fn[i];
            if ("R".equals(temp)) {
                isReverse = !isReverse;
            } else if ("D".equals(temp)) {
                if (!isReverse) {
                    input.removeFirst();
                } else {
                    input.removeLast();
                }
            }
        }
        return isReverse;
    }
}
