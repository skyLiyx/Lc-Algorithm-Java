package com.lyx.leetcode.c26;

/**
 * 2651.计算列车到站时间
 *
 * 思路：基础数学
 *
 * @version 2023/09/08
 */
public class Lc2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
