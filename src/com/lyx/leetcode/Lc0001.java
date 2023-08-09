package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1. 两数之和
 *
 * 思路：存下原始位置，再排序，利用双指针查询
 */
public class Lc0001 {

    public int[] twoSum(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i], i}); // [数值, 位置]
        }
        list.sort(Comparator.comparingInt(c -> c[0]));
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = list.get(left)[0] + list.get(right)[0];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{list.get(left)[1], list.get(right)[1]};
            }
        }
        return new int[2];
    }

}
