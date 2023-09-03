package com.lyx.leetcode;

import java.util.Arrays;

/**
 * 1921.消灭怪物的最大数量
 *
 * 思路：贪心+排序
 *
 * @version 2023/09/03
 */
public class Lc1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] time = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            time[i] = dist[i] / speed[i] + (dist[i] % speed[i] > 0 ? 1 : 0);
        }
        Arrays.sort(time);
        int res = 0, index = 0;
        while (index < time.length && res < time[index]) {
            res++;
            index++;
        }
        return res;
    }
}
