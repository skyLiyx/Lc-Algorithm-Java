package com.lyx.leetcode.c23;

import java.util.Arrays;

/**
 * 2300.咒语和药水的成功对数
 *
 * @version 2023/11/10
 */
public class Lc2300 {
    public int[] successfulPairs(int[] spells, int[] options, long success) {
        int n = spells.length;
        int[] ans = new int[n];
        Arrays.sort(options);
        for (int i = 0; i < n; i++) {
            ans[i] = find((success + spells[i] - 1) / spells[i], options);
        }
        return ans;
    }

    private int find(long num, int[] options) {
        int n = options.length;
        int l = 0, r = n;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (options[n - m - 1] < num) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
