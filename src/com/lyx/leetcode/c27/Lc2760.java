package com.lyx.leetcode.c27;

/**
 * 2760.最长奇偶子数组
 *
 * @version 2023/11/16
 */
public class Lc2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int p = 0, pre, cur, ans = 0;
        while (p < n) {
            if (nums[p] <= threshold && (nums[p] & 1) == 0) {
                pre = p;
                cur = p + 1;
                while (cur < n && nums[cur] <= threshold && (nums[pre] & 1) != (nums[cur] & 1)) {
                    pre++;
                    cur++;
                }
                ans = Math.max(ans, pre - p + 1);
                p = cur;
            } else {
                p++;
            }
        }
        return ans;
    }
}
