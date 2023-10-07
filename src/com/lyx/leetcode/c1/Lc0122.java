package com.lyx.leetcode.c1;

/**
 * 122.买卖股票的最佳时机II
 *
 * 思路：动态规划
 *
 * @version 2023/10/02
 */
public class Lc0122 {

    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price);
        }
        return sell;
    }
}
