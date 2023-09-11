package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.组合总和III
 *
 * 思路：回溯
 *
 * @version 2023/09/11
 */
public class Lc0216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(1, k, n, new boolean[9], new ArrayList<>(), res);
        return res;
    }

    private void backtrace(int start, int k, int n, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (start > n) {
            return;
        }
        for (int i = start; i < 10; i++) {
            if (used[i - 1]) {
                continue;
            }
            list.add(i);
            used[i - 1] = true;
            backtrace(i + 1, k - 1, n - i, used, list, res);
            list.remove(list.size() - 1);
            used[i - 1] = false;
        }
    }
}
