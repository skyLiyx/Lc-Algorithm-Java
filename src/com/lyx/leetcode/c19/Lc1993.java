package com.lyx.leetcode.c19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1993.树上的操作
 *
 * 思路：深度优先搜索
 *
 * @version 2023/09/23
 */
public class Lc1993 {

    class LockingTree {
        // 父节点，parent[i]表示i节点的父节点
        private final int[] parent;
        // 子节点，children[i]表示i节点的子节点列表
        private final List<Integer>[] children;
        // 加锁节点的用户，lockNodeUser[i]表示给节点i加锁的用户id，-1表示未加锁
        private final int[] lockNodeUser;

        public LockingTree(int[] parent) {
            int n = parent.length;
            this.parent = parent;
            this.children = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                this.children[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                int p = parent[i];
                if (p != -1) {
                    this.children[p].add(i);
                }
            }
            this.lockNodeUser = new int[n];
            Arrays.fill(this.lockNodeUser, -1);
        }

        public boolean lock(int num, int user) {
            if (this.lockNodeUser[num] == -1) {
                this.lockNodeUser[num] = user;
                return true;
            }
            return false;
        }

        public boolean unlock(int num, int user) {
            if (this.lockNodeUser[num] == user) {
                this.lockNodeUser[num] = -1;
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            // 检查当前节点是否未上锁
            if (this.lockNodeUser[num] != -1) {
                return false;
            }
            // 检查祖先节点是否未上锁
            int cur = num;
            while (this.parent[cur] >= 0) {
                cur = this.parent[cur];
                if (this.lockNodeUser[cur] != -1) {
                    return false;
                }
            }
            if (!hasLockedChildren(num)) {
                return false;
            }
            this.lockNodeUser[num] = user;
            return true;
        }

        private boolean hasLockedChildren(int num) {
            boolean res = this.lockNodeUser[num] != -1;
            this.lockNodeUser[num] = -1;
            for (int child : this.children[num]) {
                res |= hasLockedChildren(child);
            }
            return res;
        }
    }
}
