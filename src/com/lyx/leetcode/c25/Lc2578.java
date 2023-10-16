package com.lyx.leetcode.c25;

import java.util.Arrays;

/**
 * 2578.最小分割和
 *
 * @version 2023/10/09
 */
public class Lc2578 {
    public int splitNum(int num) {
        int n = String.valueOf(num).length();
        int[] arr = new int[n];
        while (num > 0) {
            arr[--n] = num % 10;
            num /= 10;
        }
        Arrays.sort(arr);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arr.length; i += 2) {
            sb1.append(arr[i]);
            if (i + 1 < arr.length) {
                sb2.append(arr[i + 1]);
            }
        }
        return Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
    }
}
