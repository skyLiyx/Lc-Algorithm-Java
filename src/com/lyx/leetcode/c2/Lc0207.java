package com.lyx.leetcode.c2;

import java.util.ArrayList;
import java.util.List;

/**
 * 207.课程表
 *
 * 思路：拓扑排序
 *
 * @version 2023/09/09
 */
public class Lc0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 入度数组
        int[] in = new int[numCourses];
        for (int[] p : prerequisites) {
            // p[1]指向p[0]，p[0]入度加一，p[1]的指向节点加入p[0]
            in[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }
        int count = 0;
        // 遍历访问节点
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                in[i] = -1;
                count++;
                int pointTo = 0;
                // 遍历访问节点的指向节点，入度减一，减到0之后作为下一个访问节点
                for (int j = 0; j < adj.get(i).size(); j++) {
                    int to = adj.get(i).get(j);
                    in[to]--;
                    if (in[to] == 0) {
                        pointTo = to;
                    }
                }
                i = pointTo - 1;
            }
        }
        return count == numCourses;
    }
}
