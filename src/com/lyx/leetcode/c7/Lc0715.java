package com.lyx.leetcode.c7;

import java.util.Map;
import java.util.TreeMap;

/**
 * 715.Range模块
 *
 * @version 2023/11/12
 */
public class Lc0715 {

    class RangeModule {
        private final TreeMap<Integer, Integer> map;

        public RangeModule() {
            this.map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.higherEntry(left);
            if (entry != map.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? map.lowerEntry(entry.getKey()) : map.lastEntry();
                if (start != null && start.getValue() >= right) {
                    return;
                }
                if (start != null && start.getValue() >= left) {
                    left = start.getKey();
                    map.remove(start.getKey());
                }
            }
            while (entry != null && entry.getKey() <= right) {
                right = Math.max(right, entry.getValue());
                map.remove(entry.getKey());
                entry = map.higherEntry(entry.getKey());
            }
            map.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.higherEntry(left);
            if (entry == map.firstEntry()) {
                return false;
            }
            entry = entry != null ? map.lowerEntry(entry.getKey()) : map.lastEntry();
            return entry != null && right <= entry.getValue();
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.higherEntry(left);
            if (entry != map.firstEntry()) {
                Map.Entry<Integer, Integer> start = entry != null ? map.lowerEntry(entry.getKey()) : map.lastEntry();
                if (start != null && start.getValue() >= right) {
                    int ri = start.getValue();
                    if (start.getKey() == left) {
                        map.remove(start.getKey());
                    } else {
                        map.put(start.getKey(), left);
                    }
                    if (right != ri) {
                        map.put(right, ri);
                    }
                    return;
                } else if (start != null && start.getValue() > left) {
                    if (start.getKey() == left) {
                        map.remove(start.getKey());
                    } else {
                        map.put(start.getKey(), left);
                    }
                }
            }
            while (entry != null && entry.getKey() < right) {
                if (entry.getValue() <= right) {
                    map.remove(entry.getKey());
                    entry = map.higherEntry(entry.getKey());
                } else {
                    map.put(right, entry.getValue());
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
    }

}
