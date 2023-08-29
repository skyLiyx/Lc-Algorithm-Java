package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 228.汇总区间
 *
 * 思路：双指针
 *
 * @version 2023/08/26
 */
public class Lc0228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        for (int pl = 0; pl < nums.length;) {
            int cur = nums[pl];
            int pr = pl + 1;
            while (pr < nums.length && nums[pr] == cur + 1) {
                cur += 1;
                pr += 1;
            }
            if (cur == nums[pl]) {
                res.add("" + cur);
            } else {
                res.add(nums[pl] + "->" + cur);
            }
            pl = pr;
        }
        return res;
    }
}
