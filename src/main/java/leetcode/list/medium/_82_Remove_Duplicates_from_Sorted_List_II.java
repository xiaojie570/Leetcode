package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/16.
 * 删除有序链表中所有的重复元素
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 */
public class _82_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        if(head.next != null && head.val == head.next.val) {
            while(head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;
            return deleteDuplicates(head);
        } else
            head.next = deleteDuplicates(head.next);
        return head;
    }
}
