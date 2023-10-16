package com.lyx.leetcode.c25;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2512.奖励最顶尖的K名学生
 *
 * @version 2023/10/11
 */
public class Lc2512 {
    public List<Integer> topStudents(String[] positive_feedback,
                                     String[] negative_feedback,
                                     String[] report,
                                     int[] student_id,
                                     int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : positive_feedback) {
            map.put(s, 3);
        }
        for (String s : negative_feedback) {
            map.put(s, -1);
        }
        int[] score = Arrays.stream(report)
                .mapToInt(r -> {
                    String[] split = r.split(" ");
                    int n = 0;
                    for (String s : split) {
                        n += map.getOrDefault(s, 0);
                    }
                    return n;
                }).toArray();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < student_id.length; i++) {
            list.add(new int[]{student_id[i], score[i]});
        }
        return list.stream()
                .sorted((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1])
                .limit(k)
                .map(a -> a[0])
                .collect(Collectors.toList());
    }
}
