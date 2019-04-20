package leetcode.list.medium;

import java.util.List;

/**
 * Created by lenovo on 2019/4/20.
 * 两个链表对应位相加
 */
public class _445_Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return null;
        }
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);
        ListNode answer = new ListNode(-1);
        ListNode root = answer;
        int remainder = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + remainder;
            remainder = sum / 10;
            answer.next = new ListNode(sum % 10);
            answer = answer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) {
            if (remainder != 0) {
                answer.next = new ListNode(remainder);
                answer = answer.next;
            }
        } else if (l1 != null) {
            while (l1 != null) {
                int sum = l1.val + remainder;
                answer.next = new ListNode(sum % 10);
                answer = answer.next;
                remainder = sum / 10;
                l1 = l1.next;
            }
            if (remainder != 0) {
                answer.next = new ListNode(remainder);
            }
        } else {
            while (l2 != null) {
                int sum = l2.val + remainder;
                answer.next = new ListNode(sum % 10);
                answer = answer.next;
                remainder = sum / 10;
                l2 = l2.next;
            }
            if (remainder != 0) {
                answer.next = new ListNode(remainder);
            }
        }

        root = root.next;
        return reverseLinkedList(root);
    }

    private ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
