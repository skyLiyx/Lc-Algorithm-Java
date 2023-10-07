package com.lyx.leetcode.c0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.组合总数II
 *
 * 思路：回溯
 *
 * @version 2023/09/06
 */
public class Lc0040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrace(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrace(candidates, i + 1, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
