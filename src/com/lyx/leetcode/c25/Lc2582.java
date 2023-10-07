package com.lyx.leetcode.c25;

/**
 * 2582.递枕头
 *
 * @version 2023/09/26
 */
public class Lc2582 {
    public int passThePillow(int n, int time) {
        int c = time / (n - 1);
        int m = time % (n - 1);
        if ((c & 1) == 0) {
            return m + 1;
        }
        return n - m;
    }
}
