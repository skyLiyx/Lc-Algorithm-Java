package com.lyx.leetcode.c0;

/**
 * 37.解数独
 *
 * 思路：回溯
 *
 * @version 2023/09/06
 */
public class Lc0037 {
    public void solveSudoku(char[][] board) {
        backtrace(board);
    }

    private boolean backtrace(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtrace(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c || board[k][j] == c) {
                return false;
            }
        }
        for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
            for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
                if (board[k][l] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}
