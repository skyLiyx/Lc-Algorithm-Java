package com.lyx.leetcode.c25;

import java.util.*;

/**
 * 2530.执行K次操作后的最大分数
 *
 * @version 2023/10/18
 */
public class Lc2530 {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        if (n == 1) {
            res += nums[0];
            nums[0] = (nums[0] + 2) / 3;
            k--;
            if (k == 0) {
                return res;
            }
        }
        int m = k;
        int p = nums.length - 1;
        Arrays.sort(nums);

        while (k > 0) {
            res += nums[p];
            nums[p] = (nums[p] + 2) / 3;
            k--;
            if (k == m / 3) {
                Arrays.sort(nums);
                p = n - 1;
                continue;
            }
            if (p - 1 == n / 3) {
                Arrays.sort(nums);
                p = n - 1;
                continue;
            }
            p--;

        }
        return res;
    }
}
