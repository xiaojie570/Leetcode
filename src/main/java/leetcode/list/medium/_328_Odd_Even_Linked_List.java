package leetcode.list.medium;
// even 偶数
// odd 奇数
// 偶数位置放在后面，奇数位置元素放到前面
// CSDN: https://blog.csdn.net/xiaojie_570/article/details/92773159
public class _328_Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
