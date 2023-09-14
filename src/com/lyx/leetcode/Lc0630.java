package com.lyx.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 630.课程表III
 *
 * 思路：贪心+优先队列
 *
 * @version 2023/09/11
 */
public class Lc0630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int days = 0;
        for (int[] course : courses) {
            days += course[0];
            queue.offer(course[0]);
            if (days > course[1]) {
                days -= queue.poll();
            }
        }
        return queue.size();
    }
}
