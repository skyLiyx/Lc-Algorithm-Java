package com.lyx.leetcode.c6;

/**
 * 605.种花问题
 *
 * 思路：贪心
 *
 * @version 2023/09/29
 */
public class Lc0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 && n < 2;
        }
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (check(flowerbed, i)) {
                i++;
                n--;
            }
        }
        return n == 0;
    }

    private boolean check(int[] flowerbed, int i) {
        if (flowerbed[i] != 0) {
            return false;
        }
        if (i == 0) {
            return flowerbed[1] == 0;
        }
        if (i == flowerbed.length - 1) {
            return flowerbed[i - 1] == 0;
        }
        return flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0;
    }
}

