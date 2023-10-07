package com.lyx.leetcode.c1;

import java.util.HashMap;
import java.util.Map;

/**
 * 146.LRU缓存
 *
 * 思路：哈希表+双向链表
 *
 * @version 2023/09/24
 */
public class Lc0146 {

    class LRUCache {
        // 双向链表
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 哈希表
        private final Map<Integer, DLinkedNode> cache = new HashMap<>();
        // 虚拟头尾节点
        private final DLinkedNode head = new DLinkedNode();
        private final DLinkedNode tail = new DLinkedNode();
        // 容量
        private final int capacity;
        // 大小
        private int size;

        public LRUCache(int capacity) {
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
            this.size = 0;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            DLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (this.cache.containsKey(key)) {
                DLinkedNode node = cache.get(key);
                node.value = value;
                moveToHead(node);
                return;
            }
            DLinkedNode newNode = new DLinkedNode(key, value);
            this.cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode lastNode = removeTail();
                this.cache.remove(lastNode.key);
                size--;
            }
        }

        private void addToHead(DLinkedNode node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private DLinkedNode removeTail() {
            DLinkedNode prev = this.tail.prev;
            removeNode(prev);
            return prev;
        }
    }
}
