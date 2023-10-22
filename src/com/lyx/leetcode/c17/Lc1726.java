package com.lyx.leetcode.c17;

import java.util.HashMap;
import java.util.Map;

/**
 * 1726.同积元组
 *
 * @version 2023/10/19
 */
public class Lc1726 {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if (n < 4) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int m = nums[i] * nums[j];
                map.put(m, map.getOrDefault(m, 0) + 1);
            }
        }
        int res = 0;
        for (int c : map.values()) {
            if (c > 1) {
                res += (c * (c - 1)) >> 1;
            }
        }
        return res << 3;
    }
}
