package com.lyx.leetcode;

/**
 * 1289.下降路径最小和II
 *
 * 思路：动态规划
 */
public class Lc1289 {

    public int minFallingPathSum_1(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }
        int n = grid.length;
        // 定义dp[i][j]表示第i行第j列的下降路径最小和
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                }
            }
        }
        int res = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }

    public int minFallingPathSum_2(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }
        int n = grid.length;
        // 上一行最小和
        int firstMinSum = 0;
        // 上一行第二小的和（当前行走到与上一行最小和同列时使用）
        int secondMinSum = 0;
        // 上一行最小和所在的列
        int firstMinIndex = -1;
        for (int i = 0; i < n; i++) {
            int curFirstMinSum = Integer.MAX_VALUE;
            int curSecondMinSum = Integer.MAX_VALUE;
            int curFirstMinIndex = -1;
            for (int j = 0; j < n; j++) {
                int curSum = (j != firstMinIndex ? firstMinSum : secondMinSum) + grid[i][j];
                if (curSum < curFirstMinSum) {
                    curSecondMinSum = curFirstMinSum;
                    curFirstMinSum = curSum;
                    curFirstMinIndex = j;
                } else if (curSum < curSecondMinSum) {
                    curSecondMinSum = curSum;
                }
            }
            firstMinSum = curFirstMinSum;
            secondMinSum = curSecondMinSum;
            firstMinIndex = curFirstMinIndex;
        }

        return firstMinSum;
    }
}
