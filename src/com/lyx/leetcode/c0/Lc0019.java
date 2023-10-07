package com.lyx.leetcode.c0;

import com.lyx.datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 19.删除链表的倒数第N个结点
 *
 * @version 2023/09/02
 */
public class Lc0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            count++;
            list.add(cur);
            cur = cur.next;
        }
        if (n == count) {
            return head.next;
        }
        list.get(count - n - 1).next = list.get(count - n).next;
        return head;
    }
}
