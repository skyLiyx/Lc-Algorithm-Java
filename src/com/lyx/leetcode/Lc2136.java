package com.lyx.leetcode;

import java.util.Arrays;

/**
 * 2136.全部开花的最早一天
 *
 * 思路：贪心+排序
 *
 * @version 2023/09/30
 */
public class Lc2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (i, j) -> growTime[j] - growTime[i]);
        int res = 0, days = 0;
        for (int i : id) {
            days += plantTime[i];
            res = Math.max(res, days + growTime[i]);
        }
        return res;
    }
}
