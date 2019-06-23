package leetcode.list.medium;

/**
 *  交换相邻两个节点。
 *  Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 *  CSDN: https://blog.csdn.net/xiaojie_570/article/details/93398970
 */
public class _24_Swap_Node_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode l1 = null;
        ListNode l2 = null;
        while(cur.next != null && cur.next.next != null) {
            l1 = cur.next;
            l2 = cur.next.next;
            l1.next = l2.next;
            l2.next = l1;
            cur.next = l2;
            cur = l1;
        }
        return dummy.next;
    }
}
