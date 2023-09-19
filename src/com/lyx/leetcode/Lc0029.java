package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 29.两数相除
 *
 * 思路：二分法
 *
 * @version 2023/09/15
 */
public class Lc0029 {
    public int divide(int dividend, int divisor) {
        // 列举特殊情况
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean r = false;
        if (dividend > 0) {
            dividend = -dividend;
            r = true;
        }
        if (divisor > 0) {
            divisor = -divisor;
            r = !r;
        }
        List<Integer> list = new ArrayList<>();
        list.add(divisor);
        int index = 0;
        while (list.get(index) >= dividend - list.get(index)) {
            list.add(list.get(index) + list.get(index));
            index++;
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= dividend) {
                res += 1 >> i;
                dividend -= list.get(i);
            }
        }
        return r ? -res : res;
    }
}
