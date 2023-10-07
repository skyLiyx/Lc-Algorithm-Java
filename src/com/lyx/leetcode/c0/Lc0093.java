package com.lyx.leetcode.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 93.复原IP地址
 *
 * 思路：回溯
 *
 * @version 2023/09/08
 */
public class Lc0093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrace(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrace(String s, int cur, List<String> list, List<String> res) {
        if (list.size() == 4) {
            if (cur == s.length()) {
                res.add(String.join(".", list));
            }
            return;
        }
        for (int i = cur + 1; i <= cur + 3 && i <= s.length(); i++) {
            String substr = s.substring(cur, i);
            if (isValid(substr)) {
                list.add(substr);
                backtrace(s, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() == 2) {
            return !s.startsWith("0");
        }
        if (s.length() == 3) {
            return !s.startsWith("0") && Integer.parseInt(s) <= 255;
        }
        return s.length() == 1;
    }
}
