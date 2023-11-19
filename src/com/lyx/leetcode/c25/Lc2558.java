package com.lyx.leetcode.c25;

/**
 * 2558.从数量最多的堆取走礼物
 *
 * @version 2023/10/28
 */
public class Lc2558 {
    public long pickGifts(int[] gifts, int k) {
        for (int i = 0; i < k; i++) {
            process(gifts);
        }
        long ans = 0;
        for (int g : gifts) {
            ans += g;
        }
        return ans;
    }

    private void process(int[] gifts) {
        int max = gifts[0];
        int index = 0;
        for (int i = 1; i < gifts.length; i++) {
            if (gifts[i] > max) {
                max = gifts[i];
                index = i;
            }
        }
        gifts[index] = (int)Math.sqrt(gifts[index]);
    }
}
