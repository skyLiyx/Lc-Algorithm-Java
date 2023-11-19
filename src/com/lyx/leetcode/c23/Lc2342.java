package com.lyx.leetcode.c23;

/**
 * 2342.数位和相等数对的最大和
 *
 * @version 2023/11/18
 */
public class Lc2342 {
    public int maximumSum(int[] nums) {
        int ans = -1;
        int[] m = new int[82];
        for (int n : nums) {
            int s = sum(n);
            if (m[s] > 0) {
                ans = Math.max(ans, m[s] + n);
            }
            m[s] = Math.max(m[s], n);
        }
        return ans;
    }

    private int sum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}
