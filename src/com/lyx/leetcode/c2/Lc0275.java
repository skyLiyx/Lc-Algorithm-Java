package com.lyx.leetcode.c2;

import java.util.Arrays;

/**
 * 275.H指数II
 *
 * @version 2023/10/30
 */
public class Lc0275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (m < citations[n - 1 - m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
