package com.lyx.leetcode;

import com.lyx.datastruct.ListNode;

/**
 * 2.两数相加
 *
 * 思路：按部就班
 */
public class Lc0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        l1.val = l1.val + l2.val;
        if (l1.val > 9) {
            // 进位操作
            plusNextVal(l1);
        }
        if (l1.next != null) {
            addTwoNumbers(l1.next, l2.next);
        } else if (l2.next != null) {
            l1.next = l2.next;
        }
        return l1;
    }

    private void plusNextVal(ListNode listNode) {
        listNode.val -= 10;
        if (listNode.next == null) {
            listNode.next = new ListNode(1, null);
        } else if (listNode.next.val == 9) {
            listNode.next.val = 10;
            plusNextVal(listNode.next);
        } else {
            listNode.next.val += 1;
        }
    }

}
