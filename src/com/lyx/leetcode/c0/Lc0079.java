package com.lyx.leetcode.c0;

/**
 * 79.单词搜索
 *
 * 思路：回溯
 *
 * @version 2023/09/07
 */
public class Lc0079 {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean[][] visited = new boolean[board.length][board[row].length];
                if (backtrace(board, visited, row, col, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrace(char[][] board, boolean[][] visited, int row, int col, char[] words, int index) {
        if (index == words.length) {
            return true;
        }
        if (row >= board.length || row < 0 || col >= board[row].length || col < 0 || visited[row][col]) {
            return false;
        }
        if (board[row][col] == words[index]) {
            visited[row][col] = true;
            if (backtrace(board, visited, row + 1, col, words, index + 1) ||
                    backtrace(board, visited, row, col + 1, words, index + 1) ||
                    backtrace(board, visited, row - 1, col, words, index + 1) ||
                    backtrace(board, visited, row, col - 1, words, index + 1)) {
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }
}
