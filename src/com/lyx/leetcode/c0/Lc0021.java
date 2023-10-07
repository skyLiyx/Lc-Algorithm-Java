package com.lyx.leetcode.c0;

import com.lyx.datastruct.ListNode;

/**
 * 21.合并两个有序链表
 *
 * @version 2023/09/02
 */
public class Lc0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode virtualHead = new ListNode();
        mergeTwoLists(virtualHead, list1, list2);
        return virtualHead.next;
    }

    private void mergeTwoLists(ListNode resList, ListNode list1, ListNode list2) {
        if (list1 == null) {
            resList.next = list2;
            return;
        }
        if (list2 == null) {
            resList.next = list1;
            return;
        }
        if (list1.val <= list2.val) {
            ListNode list1Next = list1.next;
            list1.next = null;
            resList.next = list1;
            mergeTwoLists(resList.next, list1Next, list2);
        } else {
            ListNode list2Next = list2.next;
            list2.next = null;
            resList.next = list2;
            mergeTwoLists(resList.next, list1, list2Next);
        }
    }
}
