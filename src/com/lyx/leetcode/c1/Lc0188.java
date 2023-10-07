package com.lyx.leetcode.c1;

/**
 * 188.买卖股票的最佳时机IV
 *
 * 思路：动态规划
 *
 * @version 2023/10/04
 */
public class Lc0188 {

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length + 1][2 * k + 1];
        for (int i = 0; i < 2 * k + 1; i++) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i - 1]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i - 1]);
            }
        }
        return dp[prices.length][2 * k];
    }
}
