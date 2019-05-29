package leetcode.list.easy;

import leetcode.list.*;

/**
 * Created by lenovo on 2019/4/12.
 * 找到链表的中间元素
 * 【解题思路】
 *      快慢指针。
 *
 *     解析： https://blog.csdn.net/xiaojie_570/article/details/90674682
 */
public class _876_Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        ListNode h = head;
        if(head.next == null) return head;
        ListNode pre1 = head, pre2 = head;
        // 注意这里面的while条件判断的都是快指针要符合条件
        while(pre2 != null && pre2.next != null) {
            pre1 = pre1.next;
            pre2 = pre2.next.next;
        }
        return pre1;
    }
}
