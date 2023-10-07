package com.lyx.leetcode.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 90.子集II
 *
 * 思路：回溯
 *
 * @version 2023/09/11
 */
public class Lc0090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrace(nums, 0, i, new ArrayList<>(), res);
        }
        return res;
    }

    private void backtrace(int[] nums, int start, int len, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && i != start) {
                continue;
            }
            list.add(nums[i]);
            backtrace(nums, i + 1, len, list, res);
            list.remove(list.size() - 1);
        }
    }
}
