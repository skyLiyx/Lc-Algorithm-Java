package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集
 *
 * 思路：回溯
 *
 * @version 2023/09/07
 */
public class Lc0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            backtrace(0, nums, k, new ArrayList<>(), res);
        }
        return res;
    }

    private void backtrace(int start, int[] nums, int k, ArrayList<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrace(i + 1, nums, k - 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
