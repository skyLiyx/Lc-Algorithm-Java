package com.lyx.leetcode.c0;

/**
 * 74.搜索二维矩阵
 *
 * 思路：二分查找
 *
 * @version 2023/09/23
 */
public class Lc0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lm = 0, rm = matrix.length;
        // 先找到所在行数，找到时target在lm行和rm行之间
        // 即target > matrix[lm][0] && target < matrix[rm][0]
        while (lm < rm - 1) {
            int mid = lm + ((rm - lm) >> 1);
            if (matrix[mid][0] > target) {
                rm = mid;
            } else if (matrix[mid][0] < target) {
                lm = mid;
            } else {
                return true;
            }
        }
        if (lm >= matrix.length) {
            return false;
        }
        int ln = 0, rn = matrix[lm].length - 1;
        // 再在该行二分查找目标值
        while (ln <= rn) {
            int mid = ln + ((rn - ln) >> 1);
            if (matrix[lm][mid] > target) {
                rn = mid - 1;
            } else if (matrix[lm][mid] < target) {
                ln = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
