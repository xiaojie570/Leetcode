package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/17.
 * 给定一个链表，和一个定值，将链表中小于该值的元素放到改值的前面，但是链表元素的相对顺序不变
 * 【解题思路】
 *  1. 使用辅助空间，数组，将小于定值x的元素先放到数组中，再将大于等于定值x的元素放到数组中
 *  2. 然后用数组改变链表中的值
 */
public class _86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length ++; temp = temp.next;
        }
        int[] arr = new int[length];
        temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.val < x)
                arr[i++] = temp.val;
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            if(temp.val >= x)
                arr[i ++] = temp.val;
            temp = temp.next;
        }
        temp = head; i = 0;
        while(temp != null) {
            temp.val = arr[i ++];
            temp = temp.next;
        }
        return head;
    }
}
