package com.lyx.leetcode;

import java.util.*;

/**
 * 16.最接近的三数之和
 *
 * 思路：双指针
 *
 * @version 2023/09/15
 */
public class Lc0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int p0 = 0; p0 <= nums.length - 3; p0++) {
            if (nums[p0] + nums[p0 + 1] + nums[p0 + 2] > target) {
                break;
            }
            if (p0 > 0 && nums[p0] == nums[p0 - 1]) {
                continue;
            }
            int p1 = p0 + 1, p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[p0] + nums[p1] + nums[p2];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum < target) {
                    int t = p1 + 1;
                    while (t < p2 && nums[t] == nums[p1]) {
                        t++;
                    }
                    p1 = t;
                } else {
                    int t = p2 - 1;
                    while (t > p1 && nums[t] == nums[p2]) {
                        t--;
                    }
                    p2 = t;
                }
            }
        }
        return res;
    }
}
