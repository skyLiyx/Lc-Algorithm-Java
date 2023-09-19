package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.四数之和
 *
 * 思路：回溯
 *
 * @version 2023/09/13
 */
public class Lc0018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrace(int[] nums, int start, long target, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == 4) {
            if (target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && i != start) {
                continue;
            }
            if (nums[i] >= 0 && target < 0) {
                break;
            }
            list.add(nums[i]);
            backtrace(nums, i + 1, target - nums[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
