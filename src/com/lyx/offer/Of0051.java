package com.lyx.offer;

/**
 * 剑指Offer 51.数组中的逆序对
 *
 * 思路：归并排序
 *
 * @version 2023/08/30
 */
public class Of0051 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return reversePairs(nums, 0, nums.length - 1);
    }

    private int reversePairs(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return reversePairs(nums, l, mid)
                + reversePairs(nums, mid + 1, r)
                + mergeAndCount(nums, l, mid, r);
    }

    private int mergeAndCount(int[] nums, int l, int m, int r) {
        int res = 0;
        int[] tmp = new int[r - l + 1];
        int index = 0, p1 = l, p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            // 在合并过程中，统计左边比右边大的数量
            // 若左边和右边相等，先移动左边指针
            if (nums[p1] > nums[p2]) {
                res += m - p1 + 1;
                tmp[index++] = nums[p2++];
            } else {
                tmp[index++] = nums[p1++];
            }
        }
        while (p1 <= m) {
            tmp[index++] = nums[p1++];
        }
        while (p2 <= r) {
            tmp[index++] = nums[p2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[i + l] = tmp[i];
        }
        return res;
    }
}
