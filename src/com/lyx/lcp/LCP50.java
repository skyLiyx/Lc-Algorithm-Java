package com.lyx.lcp;

/**
 * LCP 50.宝石补给
 *
 * @version 2023/09/15
 */
public class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        if (gem.length == 0) {
            return 0;
        }
        for (int[] op : operations) {
            int g = gem[op[0]] >> 1;
            gem[op[0]] -= g;
            gem[op[1]] += g;
        }
        int max = gem[0], min = gem[0];
        for (int i = 1; i < gem.length; i++) {
            max = Math.max(max, gem[i]);
            min = Math.min(min, gem[i]);
        }
        return max - min;
    }
}
