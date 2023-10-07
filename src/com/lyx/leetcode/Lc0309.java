package com.lyx.leetcode;

/**
 * 309.买卖股票的最佳时机含冷冻期
 *
 * 思路：动态规划
 *
 * @version 2023/10/05
 */
public class Lc0309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int buy = -prices[0];
        int noop = 0;
        int sell = 0;
        for (int i = 1; i < n; i++) {
            int buy0 = Math.max(buy, noop - prices[i]);
            int noop0 = Math.max(sell, noop);
            int sell0 = buy + prices[i];
            buy = buy0;
            noop = noop0;
            sell = sell0;
        }
        return Math.max(sell, noop);
    }
}
