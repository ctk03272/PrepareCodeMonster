package com.ctk0327.LeetCode17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        letterCombinations("23").forEach(System.out::print);
    }

    static List<String> letterCombinations(String digits) {
        ArrayList<String> ar = new ArrayList<>();
        dfs(digits, ar, "");
        return ar;
    }

    static void dfs(String digits, List<String> ar, String result) {
        if (digits.length() == 0 && !result.equals("")) {
            ar.add(result);
            return;
        }
        int now = (digits.charAt(0))-48;
        char[] target;
        switch (now) {
            case 2:
                target = new char[]{'a', 'b', 'c'};
                break;
            case 3:
                target = new char[]{'d', 'e', 'f'};
                break;
            case 4:
                target = new char[]{'g', 'h', 'i'};
                break;
            case 5:
                target = new char[]{'j', 'k', 'l'};
                break;
            case 6:
                target = new char[]{'m', 'n', 'o'};
                break;
            case 7:
                target = new char[]{'p', 'q', 'r', 's'};
                break;
            case 8:
                target = new char[]{'t', 'u', 'v'};
                break;
            case 9:
                target = new char[]{'w', 'x', 'y', 'z'};
                break;
            default:
                target = new char[0];
        }

        for (int i = 0; i < target.length; i++) {
            dfs(digits.substring(1), ar, new StringBuilder(result).append(target[i]).toString());
        }
    }

}
