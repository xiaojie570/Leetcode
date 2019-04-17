package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/17.
 * 链表中插入元素
 */
public class _147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = head, cur = head.next, nxt;
        while (cur != null) {
            // Nodes up to previous are already sorted.
            nxt = cur.next; //important to remember cur.next
            if (cur.val >= pre.val) {
                pre = cur;
            }else {
                ListNode pt = dummy;
                while (pt.next.val < cur.val) pt = pt.next;
                //insert between pt and pt.next
                cur.next = pt.next;
                pt.next = cur;
                pre.next = nxt;
            }
            cur = nxt;
        }
        return dummy.next;
    }
}
