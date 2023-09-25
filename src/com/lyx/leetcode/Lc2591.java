package com.lyx.leetcode;

/**
 * 2591.将钱分给最多的儿童
 *
 * 思路：贪心/二分查找
 *
 * @version 2023/09/22
 */
public class Lc2591 {
    /**
     * 贪心
     */
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        money -= children;
        int c = money / 7;
        int r = money % 7;
        if (r == 3 && c == children - 1) {
            return c - 1;
        }
        if (r > 0 && c == children || c > children) {
            return children - 1;
        }
        return c;
    }

    /**
     * 二分查找
     */
    public int distMoney_1(int money, int children) {
        if (money < children) {
            return -1;
        }
        int left = 0, right = Math.min(children, money / 8);
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (check(mid, money, children)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int n, int money, int children) {
        money -= n * 8;
        children -= n;
        if (money < children || (money == 4 && children == 1) || (money > 0 && children == 0)) {
            return false;
        }
        return true;
    }
}
