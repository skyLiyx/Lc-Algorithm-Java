package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 89.格雷编码
 *
 * 思路：特定公式
 *
 * @version 2023/09/11
 */
public class Lc0089 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            // 第i个格雷码为i⊕(i/2)
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
