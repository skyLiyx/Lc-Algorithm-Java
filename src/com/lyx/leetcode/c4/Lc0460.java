package com.lyx.leetcode.c4;

import java.util.HashMap;
import java.util.Map;

/**
 * 460.LFU缓存
 *
 * 思路：哈希表+双向链表
 *
 * @version 2023/09/25
 */
public class Lc0460 {

    class LFUCache {
        // 缓存键-缓存节点哈希表
        private final Map<Integer, Node> keyTable;

        // 使用频率-缓存节点哈希表
        private final Map<Integer, DLinkedList> freqTable;

        // 容量
        private final int capacity;

        // 当前使用频率最小值
        private int minFreq;

        public LFUCache(int capacity) {
            this.keyTable = new HashMap<>();
            this.freqTable = new HashMap<>();
            this.capacity = capacity;
            this.minFreq = 0;
        }

        public int get(int key) {
            if (!this.keyTable.containsKey(key)) {
                return -1;
            }
            // 刷新该缓存节点的使用频率
            Node node = this.keyTable.get(key);
            flushFrequency(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (this.keyTable.containsKey(key)) {
                Node node = this.keyTable.get(key);
                node.value = value;
                flushFrequency(node);
                return;
            }
            // 如果是新缓存键，那么构建新的缓存节点并放入哈希表
            Node newNode = new Node(key, value, 1);
            this.keyTable.put(key, newNode);
            if (this.keyTable.size() > capacity) {
                // 如果超过容量上限，获取最小使用频率对应的双向链表的尾节点
                DLinkedList minFrequencyDLinkedList = this.freqTable.get(this.minFreq);
                // 删除其缓存节点在缓存哈希表中的数据
                this.keyTable.remove(minFrequencyDLinkedList.getTail().key);
                // 然后删除该尾节点
                minFrequencyDLinkedList.remove(minFrequencyDLinkedList.getTail());
            }
            // 将新缓存节点加入使用频率哈希表中对应的双向链表中
            DLinkedList dLinkedList = this.freqTable.getOrDefault(1, new DLinkedList());
            dLinkedList.addToHead(newNode);
            this.freqTable.putIfAbsent(1, dLinkedList);
            // 更新最小使用频率为1
            this.minFreq = 1;
        }

        private void flushFrequency(Node node) {
            // 获取当前使用频率的双向链表
            DLinkedList dLinkedList = this.freqTable.get(node.freq);
            // 从该链表中删除该缓存节点
            dLinkedList.remove(node);
            if (node.freq == this.minFreq && dLinkedList.size == 0) {
                // 如果是仅有的一个最小使用频率的节点
                // 更新当前最小使用频率为原值+1
                minFreq++;
            }
            // 将该缓存节点的使用频率+1后加入对应频率的双向链表的头节点上
            DLinkedList highFrequencyDLinkedList = this.freqTable.getOrDefault(++node.freq, new DLinkedList());
            highFrequencyDLinkedList.addToHead(node);
            this.freqTable.putIfAbsent(node.freq, highFrequencyDLinkedList);
        }

        class Node {
            private int key;
            private int value;
            private int freq;
            private Node prev;
            private Node next;

            public Node() {
            }

            public Node(int key, int value, int freq) {
                this.key = key;
                this.value = value;
                this.freq = freq;
            }
        }

        class DLinkedList {
            private final Node virtualHead;
            private final Node virtualTail;
            private int size;

            public DLinkedList() {
                this.virtualHead = new Node();
                this.virtualTail = new Node();
                this.virtualHead.next = this.virtualTail;
                this.virtualTail.prev = this.virtualHead;
                this.size = 0;
            }

            public void addToHead(Node node) {
                node.next = this.virtualHead.next;
                node.prev = this.virtualHead;
                this.virtualHead.next.prev = node;
                this.virtualHead.next = node;
                this.size++;
            }

            public void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
                this.size--;
            }

            public Node getTail() {
                return this.virtualTail.prev;
            }
        }
    }
}
