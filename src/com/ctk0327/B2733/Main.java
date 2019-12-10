package com.ctk0327.B2733;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N;
    static int idx = 0;
    static int functionIdx = 0;
    static StringBuilder sb;
    static StringBuilder inputStringBuilder;
    static char[] input;
    static String inputString;
    static char[] output;
    static Map<Integer, Integer> brMap;
    static String result;
    static Stack<Integer> stk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            inputStringBuilder = new StringBuilder();
            String temp;
            input = new char[128000];
            output = new char[32768];
            brMap = new HashMap<>();
            stk = new Stack<>();
            while (!(temp = sc.nextLine()).equals("end")) {
                if (temp.contains("%")) {
                    temp = temp.substring(0, temp.indexOf("%"));
                }
                temp=temp.replace(" ","");
                inputStringBuilder.append(temp);
            }
            inputString = inputStringBuilder.toString();

            for (int j = 0; j < inputString.length(); j++) {
                if (inputString.charAt(j) == '[') {
                    stk.push(j);
                }
                if (inputString.charAt(j) == ']') {
                    int tempIdx = stk.pop();
                    brMap.put(j, tempIdx);
                    brMap.put(tempIdx, j);
                }
            }

            if (stk.isEmpty()) {
                progressFunction();
                result = sb.toString();
            } else {
                result = "COMPILE ERROR";
            }
            makePrint(i);
        }
    }

    private static void makePrint(int i) {
        System.out.printf("PROGRAM #%d:", i + 1);
        System.out.println();
        System.out.println(result);

    }

    private static void progressFunction() {
        int len = inputString.length();
        functionIdx = 0;
        while (functionIdx < len) {
            doFunction(inputString.charAt(functionIdx));
        }
    }

    private static void doFunction(char c) {
        switch (c) {
            case '>':
                idx = idx == 32767 ? 0 : idx + 1;
                break;
            case '<':
                idx = idx == 0 ? 32767 : idx - 1;
                break;
            case '+':
                output[idx] = output[idx] == 255 ? 0 : (char) (output[idx] + 1);
                break;
            case '-':
                output[idx] = output[idx] == 0 ? 255 : (char) (output[idx] - 1);
                break;
            case '.':
                sb.append(output[idx]);
                break;
            case '[':
                if (output[idx] == 0) {
                    functionIdx = brMap.get(functionIdx) + 1;
                    return;
                }
                break;
            case ']':
                if (output[idx] != 0) {
                    functionIdx = brMap.get(functionIdx)+1;
                    return;
                }
                break;
            default:
                break;
        }
        functionIdx += 1;
    }
}
