package com.lyx.leetcode;

import com.lyx.datastruct.ListNode;

/**
 * 23.合并K个升序链表
 *
 * 思路：循环选择数组中最小的节点，添加到合并链表后设置该链表指向next，直到完成合并
 */
public class Lc0023 {

    public ListNode mergeKList(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = null;
        // 定义尾节点以便连接新节点
        ListNode tail = null;
        // 最小节点
        ListNode minNode = null;
        int index;
        for (index = 0; index < lists.length; index++) {
            if (lists[index] != null) {
                minNode = lists[index];
                break;
            }
        }
        while (minNode != null) {
            // 找出最小的节点
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minNode.val) {
                    minNode = lists[i];
                    index = i;
                }
            }
            // 添加到合并节点的尾节点后面，并更新尾节点
            if (result == null) {
                result = new ListNode(minNode.val);
                tail = result;
            } else {
                tail.next = new ListNode(minNode.val);
                tail = tail.next;
            }
            // 更新数组中最小节点所在链表的指向
            lists[index] = minNode.next;
            minNode = null;
            for (index = 0; index < lists.length; index++) {
                if (lists[index] != null) {
                    minNode = lists[index];
                    break;
                }
            }
        }
        return result;
    }

}
