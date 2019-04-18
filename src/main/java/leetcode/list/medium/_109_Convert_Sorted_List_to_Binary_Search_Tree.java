package leetcode.list.medium;

/**
 * Created by lenovo on 2019/4/18.
 * 给定一个有序链表，将其转化为BST树
 */
public class _109_Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        if(temp != null)
            temp.next = null; // 只有一个元素或者只有两个元素
        else
            head = null;

        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(slow.next);
        return treeNode;
    }
}
