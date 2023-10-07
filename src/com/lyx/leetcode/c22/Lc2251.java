package com.lyx.leetcode.c22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 2251.花期内花的数目
 *
 * 思路：差分+离散
 *
 * @version 2023/09/28
 */
public class Lc2251 {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for (int[] flower : flowers) {
            cntMap.put(flower[0], cntMap.getOrDefault(flower[0], 0) + 1);
            cntMap.put(flower[1] + 1, cntMap.getOrDefault(flower[1] + 1, 0) - 1);
        }
        int n = people.length;
        Integer[] indices = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(indices, Comparator.comparingInt(i -> people[i]));
        int[] res = new int[n];
        int cur = 0;
        for (int index : indices) {
            while (!cntMap.isEmpty() && cntMap.firstKey() <= people[index]) {
                cur += cntMap.pollFirstEntry().getValue();
            }
            res[index] = cur;
        }
        return res;
    }
}
