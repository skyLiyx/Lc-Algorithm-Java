package com.lyx.leetcode.c2;

import java.util.Arrays;

/**
 * 274.H指数
 *
 * @version 2023/10/29
 */
public class Lc0274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int c = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] > c) {
                c++;
            }
        }
        return c;
    }
}
