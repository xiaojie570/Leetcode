package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/13.
 * 合并两个有序链表
 */
public class _21_Merge_Two_Sorted_Lists {
    // 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    // 非递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode ans =new ListNode(0);
        ListNode temp=ans;
        ListNode point1=l1;
        ListNode point2=l2;

        while(point1!=null && point2!=null){
            if(point1.val<=point2.val){
                temp.next = new ListNode(point1.val);
                point1= point1.next;
            }else{
                temp.next = new ListNode(point2.val);
                point2= point2.next;
            }
            temp=temp.next;
        }

        while(point1!=null){
            temp.next = new ListNode(point1.val);
            point1=point1.next;
            temp=temp.next;
        }

        while(point2!=null){
            temp.next = new ListNode(point2.val);
            point2=point2.next;
            temp=temp.next;
        }

        return ans.next;
    }
}
