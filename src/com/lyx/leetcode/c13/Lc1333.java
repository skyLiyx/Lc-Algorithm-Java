package com.lyx.leetcode.c13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1333.餐厅过滤器
 *
 * 思路：Stream流处理思想
 *
 * @version 2023/09/27
 */
public class Lc1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(r -> veganFriendly == 0 || r[2] == veganFriendly)
                .filter(r -> r[3] <= maxPrice)
                .filter(r -> r[4] <= maxDistance)
                .sorted((r1, r2) -> r2[1] - r1[1] == 0 ? r2[0] - r1[0] : r2[1] - r1[1])
                .map(r -> r[0])
                .collect(Collectors.toList());
    }
}
