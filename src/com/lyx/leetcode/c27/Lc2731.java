package com.lyx.leetcode.c27;

import java.util.Arrays;

/**
 * 2731.移动机器人
 *
 * @version 2023/10/10
 */
public class Lc2731 {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = (long)nums[i] - d;
            } else {
                pos[i] = (long)nums[i] + d;
            }
        }
        Arrays.sort(pos);
        int mod = 1000000007;
        long res = 0;
        for (int i = 1; i < n; i++) {
            res += (pos[i] - pos[i - 1]) * i % mod * (n - i) % mod;
            res %= mod;
        }
        return (int)res;
    }
}
