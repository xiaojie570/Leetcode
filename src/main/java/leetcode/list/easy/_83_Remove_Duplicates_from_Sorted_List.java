package leetcode.list.easy;

/**
 * Created by lenovo on 2019/5/30.
 * 给定一个链表，要求移除链表中的重复元素，使得重复元素只剩下一个
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/90691249
 */
public class _83_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode temp = head;
        while(temp != null) {
            ListNode next = temp.next;
            while(next != null && temp.val == next.val) {
                next = next.next;
            }
            temp.next = next;
            temp = temp.next;
        }
        return head;
    }
}
