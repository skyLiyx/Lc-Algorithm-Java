package com.lyx.lcp;

/**
 * LCP 06.拿硬币
 *
 * @version 2023/09/20
 */
public class LCP06 {
    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += (coin + 1) >> 1;
        }
        return res;
    }
}
