package com.lyx.leetcode.c0;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 *
 * @version 2023/09/06
 */
public class Lc0022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        generate("", n, n, res);
        return res;
    }

    private void generate(String s, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }
        if (l > r) {
            return;
        }
        if (l > 0) {
            generate(s + "(", l - 1, r, res);
        }
        if (r > 0) {
            generate(s + ")", l, r - 1, res);
        }
    }
}
