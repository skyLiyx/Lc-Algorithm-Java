package com.lyx.leetcode.c25;

/**
 * 2596.检查骑士巡视方案
 *
 * 思路：递归
 *
 * @version 2023/09/13
 */
public class Lc2596 {
    public boolean checkValidGrid(int[][] grid) {
        return check(grid, 0, 0, 0);
    }

    private boolean check(int[][] grid, int i, int j, int step) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != step) {
            return false;
        }
        if (step == grid.length * grid.length - 1) {
            return true;
        }
        return check(grid, i - 2, j - 1, step + 1)
                || check(grid, i - 2, j + 1, step + 1)
                || check(grid, i - 1, j - 2, step + 1)
                || check(grid, i - 1, j + 2, step + 1)
                || check(grid, i + 1, j - 2, step + 1)
                || check(grid, i + 1, j + 2, step + 1)
                || check(grid, i + 2, j - 1, step + 1)
                || check(grid, i + 2, j + 1, step + 1);
    }
}
