package com.ctk0327.CodilityTest;

import java.util.Scanner;

public class Solution2 {
    static int result;

    public int solution(String[] A) {
        result = Integer.MIN_VALUE;
        dfs(A,"",0);
        return result;
    }

    static void dfs(String[] A, String input, int count) {
        if (A.length == count) {
            if (result < input.length()) {
                result = input.length();
            }
            return;
        }
        String now = A[count];
        String concated=input.concat(now);
        boolean isAddable = true;
        for (int i = 0; i < concated.length(); i++) {
            for (int j = 0; j < concated.length(); j++) {
                if (i!=j && concated.charAt(i) == concated.charAt(j)) {
                    isAddable = false;
                }
            }
        }
        if (isAddable){
            dfs(A,concated,count+1);
        }
        dfs(A,input,count+1);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        String[] A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLine();
        }
        System.out.println(solution.solution(A));
    }
}
