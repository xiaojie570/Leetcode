package leetcode.list;

/**
 * Created by lenovo on 2019/4/12.
 * 反转链表
 * 【解题思路】
 *      三个指针，当前节点，当前节点的前一个节点，当前节点的后一个节点
 *      注意在循环之前要将head的next域设置为null
 *      while语句判断的条件是当前节点是否为null
 */
public class _206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        head.next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return head;
    }
}
