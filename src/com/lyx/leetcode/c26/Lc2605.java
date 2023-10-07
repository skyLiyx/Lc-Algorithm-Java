package com.lyx.leetcode.c26;

/**
 * 2605.从两个数字数组里生成最小数字
 *
 * 思路：哈希+计数
 *
 * @version 2023/09/05
 */
public class Lc2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] table1 = new int[10];
        for (int i : nums1) {
            table1[i] = 1;
        }
        int[] table2 = new int[10];
        for (int i : nums2) {
            table2[i] = 1;
        }
        int a = 0, b = 0;
        for (int i = 1; i < 10; i++) {
            if (table1[i] == 1 && table2[i] == 1) {
                return i;
            }
            if (a == 0 && table1[i] == 1) {
                a = i;
            }
            if (b == 0 && table2[i] == 1) {
                b = i;
            }
        }
        return Math.min(a, b) * 10 + Math.max(a, b);
    }
}
