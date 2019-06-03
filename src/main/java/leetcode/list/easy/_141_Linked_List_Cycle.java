package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/16.
 * 判断给定的链表是否有环
 * 【解题思路】 修改链表结构
 *      循环，把链表中遍历到的每个节点都指向自身，循环退出的条件就是如果当前节点的下一个节点是指向自己，那么就存在环
 *
 *      CSDN: https://blog.csdn.net/xiaojie_570/article/details/90758089
 */
public class _141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode temp = head;
        while(temp != null) {
            if(temp == temp.next) return true;  // 循环退出的条件
            ListNode next = temp.next;
            temp.next = temp;
            temp = next;
        }
        return false;
    }
}
