package com.lyx.leetcode.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 47.全排列
 *
 * 思路：回溯
 *
 * @version 2023/09/06
 */
public class Lc0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrace(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private void backtrace(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backtrace(nums, visited, list, res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

}
