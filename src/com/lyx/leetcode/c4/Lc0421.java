package com.lyx.leetcode.c4;

import java.util.HashSet;
import java.util.Set;

/**
 * 421.数组中两个数的最大异或值
 *
 * @version 2023/11/04
 */
public class Lc0421 {
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = 30; k >= 0; k--) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num >> k);
            }
            int xNext = (x << 1) | 1;
            boolean found = false;
            for (int num : nums) {
                if (set.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if (found) {
                x = xNext;
            } else {
                x = xNext - 1;
            }
        }
        return x;
    }
}
