package com.lyx.leetcode.c25;

/**
 * 2562.找出数组的串联值
 *
 * @version 2023/10/12
 */
public class Lc2562 {
    public long findTheArrayConcVal(int[] nums) {
        int l = 0, r = nums.length - 1;
        long res = 0;
        while (l < r) {
            res += nums[l++] * Math.pow(10, String.valueOf(nums[r]).length()) + nums[r--];
        }
        if (l == r) {
            res += nums[l];
        }
        return res;
    }
}
