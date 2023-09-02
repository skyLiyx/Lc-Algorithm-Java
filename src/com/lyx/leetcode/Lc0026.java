package com.lyx.leetcode;

/**
 * 26.删除有序数组中的重复项
 *
 * @version 2023/09/02
 */
public class Lc0026 {
    public int removeDuplicates(int[] nums) {
        int k = 1, c = 0;
        for (int i = 1; i < nums.length - c; i++) {
            if (nums[i] == nums[i - 1]) {
                System.arraycopy(nums, i, nums, i - 1, nums.length - i);
                i -= 1;
                c += 1;
            } else {
                k += 1;
            }
        }
        return k;
    }
}
