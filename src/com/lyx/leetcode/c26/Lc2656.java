package com.lyx.leetcode.c26;

/**
 * 2656.K个元素的最大和
 *
 * @version 2023/11/15
 */
public class Lc2656 {
    public int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max * k + k * (k - 1) / 2;
    }
}
