package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/14.
 * 复制链表，这个链表有random指针
 * 【解题思路】
 *  1. 在原链表的每一个节点之后插入一个新的结点，新节点的值等于新节点前面节点的值。
 *  2. 根据前面节点的random来找到新节点的random
 *  3. 最后将新节点从原链表中摘除出来。
 */
public class _138_Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node H = head;

        while(H != null) {
            Node temp = new Node();
            temp.val = H.val;
            temp.next = H.next;
            H.next = temp;
            H = temp.next; // 往前面迭代
        };
        Node ret = head.next;
        H = head;
        while(H != null) {
            H.next.random = H.random == null ? null : H.random.next;
            H = H.next.next;
        }
        H = head;
        Node tn = head.next;
        while(H != null) {
            H.next = tn.next;
            H = H.next;
            if(H != null) {
                tn.next = H.next;
                tn = tn.next;
            }
        }
        return ret;
    }
}
