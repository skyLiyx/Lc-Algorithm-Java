package com.lyx.leetcode.c20;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2034.股票价格波动
 */
public class Lc2034 {

    public static class StockPrice {
        private int lastTimestamp;

        // 时间戳-价格
        private final Map<Integer, Integer> map;

        // 价格-出现次数
        private final TreeMap<Integer, Integer> treeMap;

        public StockPrice() {
            this.lastTimestamp = Integer.MIN_VALUE;
            this.map = new HashMap<>();
            this.treeMap = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            this.lastTimestamp = Math.max(this.lastTimestamp, timestamp);
            if (this.map.containsKey(timestamp)) {
                int oldPrice = this.map.get(timestamp);
                int count = this.treeMap.get(oldPrice);
                if (--count == 0) {
                    this.treeMap.remove(oldPrice);
                } else {
                    this.treeMap.put(oldPrice, count);
                }
            }
            this.map.put(timestamp, price);
            this.treeMap.put(price, this.treeMap.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return this.map.get(this.lastTimestamp);
        }

        public int maximum() {
            return this.treeMap.lastKey();
        }

        public int minimum() {
            return this.treeMap.firstKey();
        }
    }

}
