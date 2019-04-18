package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/18.
 * 找到两个链表中的重合的结点的第一个结点
 */
public class _160_Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        int lenA = 0;
        while(cur != null){
            lenA ++;
            cur = cur.next;
        }

        cur = headB;
        int lenB = 0;
        while(cur != null){
            lenB ++;
            cur = cur.next;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        if(lenA > lenB) {
            for(int i=0; i<lenA-lenB; i++){
                curA = curA.next;
            }
        }
        if(lenA < lenB)  {
            for(int i=0; i<lenB-lenA; i++){
                curB = curB.next;
            }
        }
        while(curA!=null){
            if(curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
