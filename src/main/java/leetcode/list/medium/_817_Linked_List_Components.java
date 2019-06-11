package leetcode.list.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/91415475
 */
public class _817_Linked_List_Components {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int i : G) hashSet.add(i);
        int temp = 0,ret = 0;
        while(head != null) {
            while(head != null && hashSet.contains(head.val)) {
                head = head.next;
                temp ++;
            }
            if(temp > 0) {
                ret ++;
                temp = 0;
            }
            if(head != null) head = head.next;
        }
        return ret;
    }
}
