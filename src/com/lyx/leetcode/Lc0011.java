package com.lyx.leetcode;

/**
 * 11.盛最多水的容器
 *
 * 思路：双指针+贪心
 *
 * @version 2023/09/02
 */
public class Lc0011 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
