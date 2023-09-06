package com.lyx.leetcode;

import com.lyx.datastruct.TreeNode;
import javafx.util.Pair;

/**
 * 1123.最深叶节点的最近公共祖先
 *
 * 思路：递归
 *
 * @version 2023/09/06
 */
public class Lc1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return find(root).getKey();
    }

    private Pair<TreeNode, Integer> find(TreeNode root) {
        if (root == null) {
            return new Pair<>(null, 0);
        }
        Pair<TreeNode, Integer> left = find(root.left);
        Pair<TreeNode, Integer> right = find(root.right);
        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (right.getValue() > left.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Pair<>(root, left.getValue());
    }
}
