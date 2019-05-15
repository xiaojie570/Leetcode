package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/15.
 *  要求任意两个事件不能有重叠的部分，如果插入这个事件会导致重合，则插入失败，不进行插入；否则插入并返回true
 */
public class _729_My_Calendar_I {
    class Node {//节点有起始结束时间和左右子节点
        public Node(int start, int end) {
            l = start;
            r = end;
        }

        int l, r;
        Node left, right;
    }

    Node root = null;

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
        } else {
            Node cur = root;
            Node pre = null;//父节点
            boolean leftTag = false;//记录该插入的节点是左子还是右子
            while (cur != null) {
                pre = cur;
                if (end <= cur.l) {//应该在当前节点的左侧，往左子递归
                    leftTag = true;
                    cur = cur.left;
                } else if (start >= cur.r) {//应该在当前节点的右侧，往右子递归
                    leftTag = false;
                    cur = cur.right;
                } else {// 有重叠，不应该插入，返回false
                    return false;
                }
            }
            if (leftTag) {//根据tag确定是父亲的左子还是右子
                pre.left = new Node(start, end);
            } else {
                pre.right = new Node(start, end);
            }
        }
        return true;

    }
}
