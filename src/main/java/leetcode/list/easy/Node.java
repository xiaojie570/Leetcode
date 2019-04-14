package leetcode.list.easy;

/**
 * Created by lenovo on 2019/4/14.
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
