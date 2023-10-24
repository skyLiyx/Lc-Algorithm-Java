package com.lyx.leetcode.c3;

import com.lyx.datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337.打家劫舍III
 *
 * 思路：动态规划
 *
 * @version 2023/09/18
 */
public class Lc0337 {
    private final Map<TreeNode, Integer> rob = new HashMap<>();
    private final Map<TreeNode, Integer> notRob = new HashMap<>();
    public int rob(TreeNode root) {
        // 方式一
        // dfs(root);
        // return Math.max(rob.get(root), notRob.get(root));
        // 方式二
        Result result = process(root);
        return Math.max(result.rob, result.notRob);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        int robLeft = rob.getOrDefault(root.left, 0);
        int notRobLeft = notRob.getOrDefault(root.left, 0);
        int robRight = rob.getOrDefault(root.right, 0);
        int notRobRight = notRob.getOrDefault(root.right, 0);
        // 记录选择当前节点时的最大值：当前节点值 + 不选左孩子的最大值 + 不选右孩子的最大值
        rob.put(root, root.val + notRobLeft + notRobRight);
        // 记录不选择当前节点时的最大值：选择或不选择左孩子的最大值 + 选择或不选择右孩子的最大值
        notRob.put(root, Math.max(robLeft, notRobLeft) + Math.max(robRight, notRobRight));
    }



    private Result process(TreeNode node) {
        if (node == null) {
            return new Result(0, 0);
        }
        // 左孩子的结果
        Result leftResult = process(node.left);
        // 右孩子的结果
        Result rightResult = process(node.right);
        // 取当前节点=左孩子不取+右孩子不取+当前节点的值
        int rob = leftResult.notRob + rightResult.notRob + node.val;
        // 不取当前节点=左孩子取或不取中的较大值+右孩子取或不取中的较大值
        int notRob = Math.max(leftResult.rob, leftResult.notRob) + Math.max(rightResult.rob, rightResult.notRob);
        return new Result(rob, notRob);
    }

    private static class Result {
        int rob;
        int notRob;

        public Result(int rob, int notRob) {
            this.rob = rob;
            this.notRob = notRob;
        }
    }
}
