package com.lyx.leetcode.c1;

/**
 * 122.买卖股票的最佳时机III
 *
 * 思路：动态规划
 *
 * @version 2023/10/03
 */
public class Lc0123 {

    public int maxProfit(int[] prices) {
        int buy1 = prices[0];
        int sell1 = 0;
        int buy2 = prices[0] - sell1;
        int sell2 = prices[0] - buy2;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
}
