package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/15.
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 【解题思路】
 *  1. 首先用快慢指针找到链表的中间元素
 *  2. 把后半部分链表进行反转
 *  3. 将前半部分链表与后半部分链表结合起来
 */
public class _143_Reorder_List {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode l1 = head;
        ListNode l2 = head;
        while(l2.next != null && l2.next.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
        }
        l2 = l1.next;
        l1.next = null;
        // 反转链表
        l2 = reverseList(l2);
        l1 = head;
        while(l2 != null) {
            ListNode temp = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1 = l1.next;
            l1.next = temp;
            l1 = l1.next;
        }
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
