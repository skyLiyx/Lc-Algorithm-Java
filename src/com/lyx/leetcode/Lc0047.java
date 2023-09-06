package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47.全排列II
 *
 * 思路：回溯
 *
 * @version 2023/09/06
 */
public class Lc0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        // 剪枝的前提
        Arrays.sort(nums);
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
            // 当前数字和前一个数字相等，且前一个数字已经回溯完成过时，直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
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
