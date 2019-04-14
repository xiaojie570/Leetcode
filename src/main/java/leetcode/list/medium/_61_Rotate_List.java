package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/14.
 * 旋转字符串
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 */
public class _61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len=0;
        ListNode p = head;
        while (p!=null) {
            len++;
            p=p.next;
        }
        k %= len;
        if (k==0) return head;// 计算需要旋转多少次

        p=head;
        int hops = len-k-1; // 找到需要改变位置的元素
        while (hops > 0 && p!=null) {
            p = p.next;
            hops--;
        }
        ListNode newHead = p.next; //
        ListNode q = newHead;
        if (p!=null) p.next=null;
        if (q != null) {
            while (q.next != null) {
                q=q.next;
            }
            q.next = head;
            return newHead;
        } else {
            return head;
        }
    }
}
