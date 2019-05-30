package leetcode.list.easy;

import java.util.List;

/**
 * Created by lenovo on 2019/4/12.
 * 反转指定位置的链表
 *  【解题思路】
 *      1. 跟反转整个链表思路差不多，主要是注意要新申请一个头结点
 *      2. 反转的过程(while循环)与反转整个链表有一点点区别
 */
public class _92_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        int i = m;
        int num = n - m;
        while(i > 1) {
            pre = pre.next; i--;
        }
        ListNode cur = pre.next;
        while(num > 0) {
            ListNode post = cur.next;
            cur.next = post.next;
            post.next = pre.next;
            pre.next = post;
            num --;
        }
        if(m == 1) head = pre.next;
        return head;
    }
}
