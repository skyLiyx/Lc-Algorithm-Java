package com.lyx.leetcode.c1;

import java.util.Arrays;

/**
 * 137.只出现一次的数字II
 *
 * @version 2023/10/15
 */
public class Lc0137 {
    public int singleNumber(int[] nums) {
        int[] d = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                d[i] += ((num >> i) & 1);
                d[i] %= 3;
            }
        }
        String collect = Arrays.stream(d)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .reverse()
                .toString();

        return Integer.valueOf(collect, 2);
    }
}
