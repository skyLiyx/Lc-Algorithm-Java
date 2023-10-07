package com.lyx.leetcode;

import java.util.Stack;

/**
 * 901.股票价格跨度
 *
 * 思路：单调栈
 *
 * @version 2023/10/07
 */
public class Lc0901 {

    class StockSpanner {
        private final Stack<int[]> stack;

        private int index;

        public StockSpanner() {
            this.stack = new Stack<>();
            this.stack.push(new int[]{-1, Integer.MAX_VALUE});
            this.index = -1;
        }

        public int next(int price) {
            this.index++;
            while (this.stack.peek()[1] <= price) {
                this.stack.pop();
            }
            int res = index - this.stack.peek()[0];
            this.stack.push(new int[]{index, price});
            return res;
        }
    }

}
