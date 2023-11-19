package com.lyx.leetcode.c3;

/**
 * 307.区域和检索 - 数组可修改
 *
 * @version 2023/11/13
 */
public class Lc0307 {
    class NumArray {
        private final int[] nums;
        private final int[] tree;

        public NumArray(int[] nums) {
            int n = nums.length;
            this.nums = new int[n];
            this.tree = new int[n + 1];
            for (int i = 0; i < n; i++) {
                update(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            int x = val - nums[index];
            nums[index] = val;
            for (int i = index + 1; i < tree.length; i+= i & -i) {
                tree[i] += x;
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum(right + 1) - prefixSum(left);
        }

        private int prefixSum(int i) {
            int s = 0;
            for (; i > 0; i &= i - 1) {
                s += tree[i];
            }
            return s;
        }
    }
}
