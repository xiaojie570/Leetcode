package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/16.
 * 判断链表是否是循环链表
 * 【解题思路】 快慢指针
 *
 */
public class _142_Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return null;
        ListNode low = head.next;
        ListNode fast  = head.next.next; // 这个地方要注意
        while(low != fast) {
            if(fast.next == null || fast.next.next == null) return null;
            low = low.next;
            fast = fast.next.next;
        }
        fast = head;
        while(fast != low){
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }
}
