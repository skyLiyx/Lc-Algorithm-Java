package com.lyx.leetcode.c7;

/**
 * 714.买卖股票的最佳时机含手续费
 *
 * 思路：动态规划
 *
 * @version 2023/10/06
 */
public class Lc0714 {

    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
    }
}
