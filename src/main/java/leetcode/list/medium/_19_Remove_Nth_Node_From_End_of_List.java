package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/15.
 * 删除链表中倒数第n个元素
 */
public class _19_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return head;

        ListNode first = head;
        ListNode seconde = head;
        while(n -- > 0) first = first.next;

        if(first == null) return head.next; // 如果出现这种情况，应该是要删除的是链表的第一个结点
        first = first.next;

        while(first != null) {
            first = first.next;
            seconde = seconde.next;
        }
        seconde.next = seconde.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2; l2.next = l3;l3.next = l4;l4.next = l5;l5.next = null;
        _19_Remove_Nth_Node_From_End_of_List test = new _19_Remove_Nth_Node_From_End_of_List();
        test.removeNthFromEnd(l1,2);
    }
}
