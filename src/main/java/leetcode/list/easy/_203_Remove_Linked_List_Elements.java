package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/12.
 *
 * 给定一个链表和一个值，将链表中的给定值节点删除。
 */
public class _203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        if(head.val == val)
            return removeElements(head.next,val);

        ListNode pre = head,cur = head;
        while(cur != null) {
            if(cur.val == val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
