package leetcode.list.medium;

/**
 * 题目难度：easy
 * Created by lenovo on 2019/4/18.
 * 给定一个链表，移除链表中的重复元素。
 * 【解题思路】
 *  1. 就是两个指针。
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
