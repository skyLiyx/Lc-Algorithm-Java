package com.lyx.leetcode;

import java.util.*;

/**
 * 52.N皇后II
 *
 * 思路：回溯
 *
 * @version 2023/09/07
 */
public class Lc0052 {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("COUNT", 0);
        backtrace(board, 0, new boolean[n], map);
        return map.get("COUNT");
    }

    private void backtrace(char[][] board, int row, boolean[] occupied, Map<String, Integer> map) {
        // 通过当前执行行数row和被占用列的标记occupied来保证每行每列不会重复
        // 后续判断只需要判断斜线方向是否重复即可
        if (row == board.length) {
            map.put("COUNT", map.get("COUNT") + 1);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (occupied[col]) {
                continue;
            }
            if (isValid(board, row, col)) {
                occupied[col] = true;
                board[row][col] = 'Q';
                backtrace(board, row + 1, occupied, map);
                board[row][col] = '.';
                occupied[col] = false;
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        // 只须要判断同一斜线方向不会重复即可
        int i = row;
        int j = col;
        while (i < board.length && j < board.length) {
            if (board[i++][j++] == 'Q') {
                return false;
            }
        }
        i = row;
        j = col;
        while (i > 0 && j > 0) {
            if (board[--i][--j] == 'Q') {
                return false;
            }
        }
        i = row;
        j = col;
        while (i > 0 && j < board.length - 1) {
            if (board[--i][++j] == 'Q') {
                return false;
            }
        }
        i = row;
        j = col;
        while (i < board.length - 1 && j > 0) {
            if (board[++i][--j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
