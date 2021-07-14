package com.ctk0327.SkillCheck4;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] { { 5, 3 }, { 3, 10 }, { 10, 6 } }));
    }

    public int solution(int[][] matrix_sizes) {
        int[][] dp = new int[201][201];
        int n = matrix_sizes.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (i == 0) {
                    dp[j][j + i] = 0;
                } else {
                    dp[j][j + i] = Integer.MAX_VALUE;
                    for (int k = j; k < j + i; k++) {
                        dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i]
                                                              + matrix_sizes[j][0] * matrix_sizes[k][1]
                                                                * matrix_sizes[j + i][1]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
