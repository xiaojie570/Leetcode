package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/18.
 * 找到两个链表中的重合的结点的第一个结点
 *
 * 【解题思路】
 * 一定是按照短的链表进行遍历的，所以需要将长的链表遍历到跟短的链表一样长再开始一起遍历

 步骤一： 首先得到两个链表的长度。
 步骤二： 遍历长的那个链表，使得长的链表的剩下的长度等于短的链表的长度
 步骤三： 判断两个链表是否相等，如果相等就直接返回，否则继续向下遍历
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
