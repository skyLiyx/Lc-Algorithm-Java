package com.lyx.leetcode.c14;

import java.util.ArrayList;
import java.util.List;

/**
 * 1462.课程表IV
 *
 * 思路：深度优先搜索+拓扑排序
 *
 * @version 2023/09/12
 */
public class Lc1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            list.get(p[0]).add(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(list, visited, isPre, i);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }

    private void dfs(List<List<Integer>> list, boolean[] visited, boolean[][] isPre, int cur) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        for (int i : list.get(cur)) {
            dfs(list, visited, isPre, i);
            isPre[cur][i] = true;
            for (int j = 0; j < isPre.length; j++) {
                isPre[cur][j] = isPre[cur][j] | isPre[i][j];
            }
        }
    }
}
