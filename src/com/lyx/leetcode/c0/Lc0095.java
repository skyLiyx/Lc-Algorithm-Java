package com.lyx.leetcode.c0;

import com.lyx.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95.不同的二叉搜索树II
 *
 * 思路：回溯
 *
 * @version 2023/09/06
 */
public class Lc0095 {
    public List<TreeNode> generateTree(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generate(start, i - 1);
            List<TreeNode> rightList = generate(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    res.add(new TreeNode(i, left, right));
                }
            }
        }
        return res;
    }
}
