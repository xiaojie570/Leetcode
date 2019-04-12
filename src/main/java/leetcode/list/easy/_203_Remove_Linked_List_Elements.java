package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/12.
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
