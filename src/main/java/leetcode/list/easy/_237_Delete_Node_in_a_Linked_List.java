package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/12.
 * 删除链表中的元素
 * 【解题思路】
 *      后面的元素覆盖前面的元素即可
 */
public class _237_Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
