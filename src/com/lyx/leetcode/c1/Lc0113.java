package com.lyx.leetcode.c1;

import com.lyx.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113.路径总和II
 *
 * 思路：回溯/深度优先搜索
 *
 * @version 2023/09/11
 */
public class Lc0113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(list));
        }
        dfs(root.left, targetSum, list, res);
        dfs(root.right, targetSum, list, res);
        list.remove(list.size() - 1);
    }
}
