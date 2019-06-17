package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/20.
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * 给定一个链表和一个数字k，要将原链表分开，分为连续的k个部分。
 * 【解题思路】
 *  1. 首先要得到原链表的长度，以及计算每一部分要存储多少元素，和当前元素可不可以平均分到k个部分，如果不能，那多出来的元素要放到变量remaining中
 *  2. 遍历链表，每一部分都通过计数看是否达到了存储数据的个数，如果达到了，就将当前链表截断。
 *
 *  CSDN: https://blog.csdn.net/xiaojie_570/article/details/92616980
 */
public class _725_Split_Linked_List_in_Parts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode temp = root;
        int length = 0;
        while(temp != null) {
            temp = temp.next;
            length ++;
        }
        int each = length / k;  // 每一部分要存储多少数据
        int remaining = length % k;
        ListNode[]  ret = new ListNode[k];
        temp = root;
        for(int i = 0; i < k && temp != null;i++) {
            ret[i] = temp;
            int total = each - 1 + (remaining -- > 0 ? 1 : 0);
            ListNode prev = temp;
            while (total -- >= 0 && temp != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null; // 截断了
        }
        return ret;
    }
}
