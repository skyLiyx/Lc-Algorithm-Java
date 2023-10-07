package com.lyx.leetcode;

/**
 * 121.买卖股票的最佳时机
 *
 * 思路：动态规划
 *
 * @version 2023/10/01
 */
public class Lc0121 {

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            sell = Math.max(sell, price - buy);
        }
        return sell;
    }
}
