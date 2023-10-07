package com.lyx.leetcode.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 77.组合
 *
 * 思路：回溯
 *
 * @version 2023/09/07
 */
public class Lc0077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrace(int start, int n, int k, ArrayList<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrace(i + 1, n, k - 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
