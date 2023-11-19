package com.lyx.leetcode.c6;

/**
 * 689.三个无重叠子数组的最大和
 *
 * @version 2023/11/19
 */
public class Lc0689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        long[] s = new long[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            s[i] = sum[i + k] - sum[i];
        }
        int a = 0, b = k, c = k << 1;
        int[] ans = new int[]{a, b, c};
        long max1 = s[0], max2 = s[k] + s[0], max3 = s[k] + s[0] + s[k << 1];
        int idx1 = 0, idx2 = k, idx3 = 0;
        while (c < n - k) {
            a++;
            b++;
            c++;
            if (s[a] > max1) {
                max1 = s[a];
                idx1 = a;
            }
            if (max1 + s[b] > max2) {
                max2 = max1 + s[b];
                idx2 = b;
                idx3 = idx1;
            }
            if (max2 + s[c] > max3) {
                max3 = max2 + s[c];
                ans[0] = idx3;
                ans[1] = idx2;
                ans[2] = c;
            }
        }
        return ans;
    }
}
