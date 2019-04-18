package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/18.
 * 判断给定的链表是否是回文链表
 * 【解题思路】
 *  1. 将链表的前半部分进行反转
 *  2. 然后从中间开始往两边进行遍历
 */
public class _234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head, fast = head;
        ListNode newHead = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = next;
        }
        if(fast != null) slow = slow.next;
        while (slow != null) {
            if(slow.val != newHead.val) return false;
            slow = slow.next;
            newHead = newHead.next;
        }
        return true;
    }
}
