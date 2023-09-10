package com.lyx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 210.课程表II
 *
 * 思路：拓扑排序
 *
 * @version 2023/09/10
 */
public class Lc0210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];
        for (int[] p : prerequisites) {
            in[p[0]]++;
            list.get(p[1]).add(p[0]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                in[i] = -1;
                res.add(i);
                int pointTo = 0;
                for (int j = 0; j < list.get(i).size(); j++) {
                    int to = list.get(i).get(j);
                    in[to]--;
                    if (in[to] == 0) {
                        pointTo = to;
                    }
                }
                i = pointTo - 1;
            }
        }
        if (res.size() < numCourses) {
            return new int[0];
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
