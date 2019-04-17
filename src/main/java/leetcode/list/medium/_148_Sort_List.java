package leetcode.list.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/17.
 * 给定的链表排序
 * 【解题思路】
 *  1. 找到链表的长度，定义一个数组存储链表中的元素值。
 *  2. 对数组进行排序，将排序后的结果存到链表中即可
 */
public class _148_Sort_List {
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length ++;
            temp = temp.next;
        }
        int []arr = new int[length];
        int i = 0; temp = head;
        while(temp != null) {
            arr[i ++] = temp.val;
            temp  = temp.next;
        }
        Arrays.sort(arr);
        temp = head; i = 0;
        while(temp != null) {
            temp.val = arr[i ++];
            temp = temp.next;
        }
        return head;
    }
}
